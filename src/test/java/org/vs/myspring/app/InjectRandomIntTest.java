package org.vs.myspring.app;

import org.junit.Assert;
import org.junit.Test;
import org.vs.myspring.system.MyApplicationContext;

/**
 * Created by Denis Karpov on 05.07.2018.
 */
public class InjectRandomIntTest {
    @Test
    public void injectTest() {
        Cleaner cleaner = MyApplicationContext.getInstance().getBean(Cleaner.class);
        Assert.assertTrue(cleaner.getSpeed() > 6);
    }
}
