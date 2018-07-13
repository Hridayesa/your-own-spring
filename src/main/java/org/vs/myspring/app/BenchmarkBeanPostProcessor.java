package org.vs.myspring.app;

import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import org.vs.myspring.system.MyBeanPostProcessor;

import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Arrays;

/**
 * Created by Denis Karpov on 13.07.2018.
 */
@Slf4j
public class BenchmarkBeanPostProcessor implements MyBeanPostProcessor {
    @Override
    public <T> T postProcessAfterInitialization(T obj, Class<? extends T> implClass) {
        T res = obj;
        boolean isAnyMethodWithBenchmark = Arrays.stream(implClass.getMethods())
                .map(method -> getOriginalMethod(implClass,method))
                .anyMatch(method -> method.isAnnotationPresent(Benchmark.class));
        if ( implClass.isAnnotationPresent(Benchmark.class) || isAnyMethodWithBenchmark){
            res = (T) Proxy.newProxyInstance(implClass.getClassLoader(), implClass.getInterfaces(), (proxy, method, args) -> {
                Object methodRes;
                if (implClass.isAnnotationPresent(Benchmark.class) || getOriginalMethod(implClass,method).isAnnotationPresent(Benchmark.class)) {
                    long before = System.nanoTime();
                    methodRes = method.invoke(obj, args);
                    long length = System.nanoTime() - before;
                    log.info("### "+implClass.getName()+"."+method.getName()+"()   execution time:"+length/1000+"ms");
                }
                else {
                    methodRes = method.invoke(obj,args);
                }
                return methodRes;
            });
        }
        return res;
    }

    @SneakyThrows
    private Method getOriginalMethod(Class implClass, Method method){
        return implClass.getMethod(method.getName(),method.getParameterTypes());
    }
}
