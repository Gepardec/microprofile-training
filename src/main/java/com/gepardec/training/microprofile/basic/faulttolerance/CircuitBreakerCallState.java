package com.gepardec.training.microprofile.basic.faulttolerance;

import com.gepardec.training.microprofile.CallFailedException;

import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

@SessionScoped
public class CircuitBreakerCallState implements Serializable {

    private int failEachCount = 2;

    private int failAfterEachCount = 2;

    private long callCount = 0;

    private long count = 1;

    private int failureCount = 0;

    public synchronized void init(final int failEachCount, final int failAfterEachCount) {
        this.failEachCount = failEachCount;
        this.failAfterEachCount = failAfterEachCount;
    }

    public synchronized void failIfSupposedTo() {
        callCount++;
        if (count % failEachCount == 0) {
            count = 1;
            failureCount++;
        } else if (failureCount > 0 && failureCount <= failAfterEachCount) {
            failureCount++;
            throw new CallFailedException("CircuitBreaker error on calls: '" + callCount + "', failureCount: '" + (failureCount - 1) + "'");
        } else {
            count++;
            failureCount = 0;
        }
    }

    public synchronized void reset() {
        callCount = 0;
        count = 1;
        failureCount = 0;
    }
}
