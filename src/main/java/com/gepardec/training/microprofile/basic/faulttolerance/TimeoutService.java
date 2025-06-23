package com.gepardec.training.microprofile.basic.faulttolerance;

import org.eclipse.microprofile.faulttolerance.Timeout;
import org.slf4j.Logger;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;

@Dependent
public class TimeoutService {

    @Inject
    private Logger log;

    @Timeout
    public void fails() {
        try {
            Thread.sleep(4000);
            log.warn("Should not have got that far :(");
        } catch (InterruptedException e) {
            throw new IllegalStateException("Could not wait", e);
        }
    }
}
