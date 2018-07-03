package org.vs.myspring.app;

public class IRobot {
    private final Cleaner cleaner = new CleanerImpl();
    private final Speaker speaker = new SpeakerImpl();

    void cleanRoom() {
        speaker.speak("START !!!");
        cleaner.clean();
        speaker.speak("STOP !!!");
    }
}
