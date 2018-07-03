package org.vs.myspring.app;

public class IRobot {
    private final Cleaner cleaner = MyApplicationContext.getInstance().getBean(Cleaner.class);
    private final Speaker speaker = MyApplicationContext.getInstance().getBean(Cleaner.class);

    void cleanRoom() {
        speaker.speak("START !!!");
        cleaner.clean();
        speaker.speak("STOP !!!");
    }
}
