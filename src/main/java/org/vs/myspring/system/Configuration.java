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
        Class<? extends T> res = (Class<? extends T>) implClasses.get(key);

        if (res==null && !key.isInterface()){
            res = key;
        }

        // сканируем
        if (res == null) {
            res = scanForImpl(key);
        }

        // кэшируем
        if (res != null) {
            implClasses.put(key, res);
        }
        return res;
    }

    public <T> Set<Class<? extends T>> getImplClasses(Class<T> key) {
        return scanner.getSubTypesOf(key);
    }

    private <T> Class<? extends T> scanForImpl(Class<T> key) {
        Set<Class<? extends T>> set = scanner.getSubTypesOf(key);
        if (key.isInterface() && set.size() != 1) {
            throw new RuntimeException(key + " has 0 or more than one impl.");
        }
        return set.iterator().next();
    }
}
