package org.vs.myspring.app;

import org.junit.Assert;
import org.junit.Test;
import org.vs.myspring.system.Configuration;
import org.vs.myspring.system.MyApplicationContext;

/**
 * Created by Denis Karpov on 05.07.2018.
 */
public class InjectRandomIntTest {
    @Test
    public void injectTest() {
        MyApplicationContext context = new MyApplicationContext(new Configuration("org.vs.myspring"));
        Cleaner cleaner = context.getBean(Cleaner.class);
        Assert.assertTrue(cleaner.getSpeed() > 6);
    }
}
