package org.vs.myspring.system;

import org.reflections.Reflections;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Created by Denis Karpov on 05.07.2018.
 */
public class Configuration {
    private final Map<Class, Class> implClasses = new HashMap<>();
    private final Reflections scanner;

    public Configuration(String packageName) {
        scanner = new Reflections(packageName);
    }

    public <T> Class<? extends T> getImplClass(Class<T> key) {
        // пробуем взять из кэша
        Class<? extends T> res = (Class<? extends T>)implClasses.get(key);

        // сканируем
        if (res==null){
            res = scanForImpl(key);
        }
        res = (res != null) ? res : key;

        // кэшируем
        if (res!=null){
            implClasses.put(key, res);
        }
        return res;
    }

    private <T> Class<? extends T> scanForImpl(Class<T> key) {
        Set<Class<? extends T>> set = scanner.getSubTypesOf(key);
        if (set.size() != 1) {
            throw new RuntimeException(key + " has 0 or more than one impl.");
        }
        return set.iterator().next();
    }
}
