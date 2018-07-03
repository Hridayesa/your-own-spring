package org.vs.myspring.app;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class CleanerImpl implements Cleaner {
    @Override
    public void clean() {
        log.info("CLEAN !!!");
    }
}
