package org.vs.myspring.app;

import org.vs.myspring.system.ApplicationContext;
import org.vs.myspring.system.Configuration;
import org.vs.myspring.system.MyApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new MyApplicationContext(new Configuration("org.vs.myspring"));
        IRobot robot = context.getBean(IRobot.class);
        robot.cleanRoom();
    }
}
