package org.vs.myspring.system;

import lombok.SneakyThrows;
import org.reflections.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.Random;
import java.util.Set;

public class MyApplicationContext {
    private final static MyApplicationContext context = new MyApplicationContext();
    private Configuration configuration = new Configuration("org.vs.myspring"); // Название пакета потом надо будет убрать

    public static MyApplicationContext getInstance(){
        return context;
    }

    @SneakyThrows
    public <T> T getBean(Class<T> key){
        Class<? extends T> implClass = configuration.getImplClass(key);

        T res = (T)implClass.newInstance();

        postProcess(res);

        return res;
    }

    private <T> void postProcess(T res) {
        for(MyBeanPostProcessor postProcessor: postProsessors){
            postProcessor.postProcess(res);
        }

        //TODO Вынести в реализацию MyBeanPostProcessor
//        Set<Field> fields = ReflectionUtils.getAllFields(implClass);
//        for (Field field : fields) {
//            InjectRandomInt annotation = field.getAnnotation(InjectRandomInt.class);
//            if (annotation != null) {
//                int min = annotation.min();
//                int max = annotation.max();
//                Random random = new Random();
//                int value = min + random.nextInt(max - min);
//                field.setAccessible(true);
//                field.set(res,value);
//            }
//        }
    }

}
