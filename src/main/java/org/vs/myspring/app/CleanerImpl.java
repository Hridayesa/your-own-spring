package org.vs.myspring.app;

import lombok.Getter;
import lombok.Setter;
import lombok.extern.slf4j.Slf4j;
import org.vs.myspring.system.InjectRandomInt;
import org.vs.myspring.system.MyPostConstruct;

@Slf4j
@Getter
@Setter
public class CleanerImpl implements Cleaner {
    @InjectRandomInt(min = 7, max = 17)
    private int speed;

    @MyPostConstruct
    private void init() {
        log.info("Hi from CLEANER (speed=" + speed + ")");
    }

    @Override
    @Benchmark
    public void clean() {
        log.info("CLEAN!!! (speed=" + speed + ")");
    }
}
