package com.gepardec.training.microprofile.basic.faulttolerance;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import org.apache.commons.lang3.concurrent.ConcurrentUtils;
import org.slf4j.Logger;

import java.util.concurrent.Future;

@Dependent
public class AsynchronousService {

    @Inject
    private Logger log;

    public Future<Void> longRunning() {
        try {
            Thread.sleep(1000);
            log.info("Invoked asynchronous method");
        } catch (InterruptedException e) {
            throw new IllegalStateException("Could not sleep", e);
        }
        return ConcurrentUtils.constantFuture(null);
    }
}
