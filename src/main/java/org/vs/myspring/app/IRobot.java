package org.vs.myspring.app;

import org.vs.myspring.system.MyApplicationContext;

public class IRobot {
    private final Cleaner cleaner = MyApplicationContext.getInstance().getBean(Cleaner.class);
    private final Speaker speaker = MyApplicationContext.getInstance().getBean(Speaker.class);

    void cleanRoom() {
        speaker.speak("START !!!");
        cleaner.clean();
        speaker.speak("STOP !!!");
    }
}
