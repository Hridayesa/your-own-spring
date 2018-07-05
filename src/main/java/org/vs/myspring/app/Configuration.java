package org.vs.myspring.app;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Denis Karpov on 05.07.2018.
 */
public class Configuration {
    private final Map<Class, Class> implClasses = new HashMap<>();

    public Configuration() {
        implClasses.put(Cleaner.class, CleanerImpl.class);
        implClasses.put(Speaker.class, SpeakerImpl.class);
    }

    public <T> Class<T> getImplClass(Class<T> key) {
        Class<T> res = (Class<T>)implClasses.get(key);
        return (res != null) ? res : key;
    }
}
