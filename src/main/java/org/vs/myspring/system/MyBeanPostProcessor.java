package org.vs.myspring.system;

/**
 * Created by Denis Karpov on 05.07.2018.
 */
public interface MyBeanPostProcessor {
    default <T> T postProcessBeforeInitialization(T obj, Class<? extends T> implClass){
        return obj;
    }

    default <T> T postProcessAfterInitialization(T obj, Class<? extends T> implClass){
        return obj;
    }
}
