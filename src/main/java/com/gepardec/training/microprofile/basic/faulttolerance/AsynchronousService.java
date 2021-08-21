package com.gepardec.training.microprofile.basic.faulttolerance;

import org.apache.commons.lang3.concurrent.ConcurrentUtils;
import org.slf4j.Logger;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
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
