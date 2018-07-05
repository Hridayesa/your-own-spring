package org.vs.myspring.app;

import lombok.SneakyThrows;

public class MyApplicationContext {
    private final static MyApplicationContext context = new MyApplicationContext();
    private Configuration configuration = new Configuration();

    public static MyApplicationContext getInstance(){
        return context;
    }

    @SneakyThrows
    public <T> T getBean(Class<T> key){
        Class implClass = configuration.getImplClass(key);

        T res = (T)implClass.newInstance();

        return res;
    }

}
