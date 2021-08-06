package com.gepardec.training.microprofile.basic.faulttolerance;

import org.apache.commons.lang3.concurrent.ConcurrentUtils;
import org.eclipse.microprofile.faulttolerance.Asynchronous;

import javax.enterprise.context.Dependent;
import java.util.concurrent.Future;

@Dependent
public class AsynchronousService {

    @Asynchronous
    public Future<Void> invoke() {
        double value = 10.0;
        for (long i = 1; i <= 100_000_000L; i++) {
            if (Thread.interrupted()) {
                break;
            }
            value = (value * i * 100) / 10;
        }
        return ConcurrentUtils.constantFuture(null);
    }
}
