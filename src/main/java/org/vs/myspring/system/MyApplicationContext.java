package org.vs.myspring.system;

import lombok.SneakyThrows;
import org.reflections.ReflectionUtils;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

public class MyApplicationContext implements ApplicationContext {
    private final Configuration configuration;
    private final List<MyBeanPostProcessor> postProcessors = new LinkedList<>();

    public MyApplicationContext(Configuration configuration) {
        this.configuration = configuration;
        initPostProcessors(configuration);
    }

    @SneakyThrows
    private void initPostProcessors(Configuration configuration) {
        Set<Class<? extends MyBeanPostProcessor>> postProcessorClasses = configuration.getImplClasses(MyBeanPostProcessor.class);
        for (Class<? extends MyBeanPostProcessor> implClass : postProcessorClasses) {
            MyBeanPostProcessor postProcessor = implClass.newInstance();
            if (ApplicationContextAware.class.isAssignableFrom(implClass)) {
                ((ApplicationContextAware) postProcessor).setApplicationContext(this);
            }
            postProcessors.add(postProcessor);
        }
    }

    @SneakyThrows
    public <T> T getBean(Class<T> key) {
        Class<? extends T> implClass = configuration.getImplClass(key);

        T res = (T) implClass.newInstance();

        res = postProcess(res, implClass);

        invokeInit(implClass, res);

        return res;
    }

    private <T> void invokeInit(Class<? extends T> implClass, T obj) throws IllegalAccessException, InvocationTargetException {
        Set<Method> methods = ReflectionUtils.getAllMethods(implClass, method -> method.isAnnotationPresent(MyPostConstruct.class));
        for (Method method : methods) {
            method.setAccessible(true);
            method.invoke(obj);
        }
    }

    private <T> T postProcess(T res, Class<? extends T> implClass) {
        for (MyBeanPostProcessor postProcessor : postProcessors) {
            res = postProcessor.postProcess(res, implClass);
        }
        return res;
    }

}
