package org.vs.myspring.app;

public class IRobot {
    @MyAutowire
    private final Cleaner cleaner;
    @MyAutowire
    private final Speaker speaker;

    void cleanRoom() {
        speaker.speak("START !!!");
        cleaner.clean();
        speaker.speak("STOP !!!");
    }
}
