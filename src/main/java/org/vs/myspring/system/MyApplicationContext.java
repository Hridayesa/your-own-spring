package org.vs.myspring.system;

import lombok.SneakyThrows;

public class MyApplicationContext {
    private final static MyApplicationContext context = new MyApplicationContext();
    private Configuration configuration = new Configuration("org.vs.myspring"); // Название пакета потом надо будет убрать

    public static MyApplicationContext getInstance(){
        return context;
    }

    @SneakyThrows
    public <T> T getBean(Class<T> key){
        Class<? extends T> implClass = configuration.getImplClass(key);

        T res = (T)implClass.newInstance();

        return res;
    }

}
