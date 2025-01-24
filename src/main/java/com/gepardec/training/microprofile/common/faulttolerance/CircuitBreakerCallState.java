package com.gepardec.training.microprofile.common.faulttolerance;

import com.gepardec.training.microprofile.CallFailedException;

import jakarta.enterprise.context.SessionScoped;
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

    public synchronized void resetState() {
        callCount = 0;
        count = 1;
        failureCount = 0;
    }

    public synchronized void resetConfiguration() {
        failAfterEachCount = 5;
        failEachCount = 5;
    }

    public int getFailEachCount() {
        return failEachCount;
    }

    public int getFailAfterEachCount() {
        return failAfterEachCount;
    }
}
