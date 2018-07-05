package org.vs.myspring.system;

/**
 * Created by Denis Karpov on 05.07.2018.
 */
public interface ApplicationContext {
    <T> T getBean(Class<T> key);
}
