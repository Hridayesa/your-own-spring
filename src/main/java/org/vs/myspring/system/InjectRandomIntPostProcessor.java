package org.vs.myspring.system;

import lombok.SneakyThrows;
import org.reflections.ReflectionUtils;

import java.lang.reflect.Field;
import java.util.Random;
import java.util.Set;

/**
 * Created by Denis Karpov on 05.07.2018.
 */
public class InjectRandomIntPostProcessor implements MyBeanPostProcessor{
    @Override
    @SneakyThrows
    public <T> T postProcess(T obj, Class<? extends T> implClass) {
        Set<Field> fields = ReflectionUtils.getAllFields(implClass);
        for (Field field : fields) {
            InjectRandomInt annotation = field.getAnnotation(InjectRandomInt.class);
            if (annotation != null) {
                int min = annotation.min();
                int max = annotation.max();
                Random random = new Random();
                int value = min + random.nextInt(max - min);
                field.setAccessible(true);
                field.set(obj,value);
            }
        }
        return obj;
    }
}
