package org.vs.myspring.system;

/**
 * Created by Denis Karpov on 05.07.2018.
 */
public interface MyBeanPostProcessor {
    <T> T postProcess(T obj, Class<? extends T> implClass);
}
