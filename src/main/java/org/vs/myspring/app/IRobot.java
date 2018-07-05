package org.vs.myspring.app;

import org.vs.myspring.system.MyAutowire;

public class IRobot {
    @MyAutowire
    private Cleaner cleaner;
    @MyAutowire
    private Speaker speaker;

    void cleanRoom() {
        speaker.speak("START !!!");
        cleaner.clean();
        speaker.speak("STOP !!!");
    }
}
