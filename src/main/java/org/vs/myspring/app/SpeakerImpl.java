package org.vs.myspring.app;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class SpeakerImpl implements Speaker {

    @Override
    public void speak(String msg) {
        log.info(msg);
    }
}
