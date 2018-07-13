package org.vs.myspring.system;

import lombok.SneakyThrows;
import org.reflections.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.Set;

/**
 * Created by Denis Karpov on 05.07.2018.
 */
public class MyAutowirePostProcessor implements MyBeanPostProcessor, ApplicationContextAware {
    ApplicationContext context;

    @Override
    @SneakyThrows
    public <T> T postProcessBeforeInitialization(T obj, Class<? extends T> implClass) {
        Set<Field> fields = ReflectionUtils.getAllFields(implClass);
        for(Field field: fields){
            if (field.isAnnotationPresent(MyAutowire.class)){
                field.setAccessible(true);
                field.set(obj, context.getBean(field.getType()));
            }
        }
        return obj;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) {
        this.context = applicationContext;
    }
}
