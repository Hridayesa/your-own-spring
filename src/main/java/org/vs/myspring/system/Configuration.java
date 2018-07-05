package org.vs.myspring.system;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Denis Karpov on 05.07.2018.
 */
public class Configuration {
    private final Map<Class, Class> implClasses = new HashMap<>();

    public Configuration() {
    }

    public <T> Class<T> getImplClass(Class<T> key) {
        Class<T> res = (Class<T>)implClasses.get(key);
        return (res != null) ? res : key;
    }
}
