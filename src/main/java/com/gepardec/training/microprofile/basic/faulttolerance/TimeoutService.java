package com.gepardec.training.microprofile.basic.faulttolerance;

import org.slf4j.Logger;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;

@Dependent
public class TimeoutService {

    @Inject
    private Logger log;

    public void timedout() {
        try {
            Thread.sleep(4000);
            log.warn("Should not have got that far :(");
        } catch (InterruptedException e) {
            throw new IllegalStateException("Could not wait", e);
        }
    }
}
