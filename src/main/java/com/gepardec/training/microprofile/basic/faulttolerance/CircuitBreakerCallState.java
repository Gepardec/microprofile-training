package com.gepardec.training.microprofile.basic.faulttolerance;

import com.gepardec.training.microprofile.CallFailedException;

import javax.enterprise.context.SessionScoped;
import java.io.Serializable;

@SessionScoped
public class CircuitBreakerCallState implements Serializable {

    private long count = 0;

    private int failureCount = -1;

    public synchronized void failIfSupposedTo() {
        count++;
        if (count % 10 == 0) {
            failureCount++;
        } else if (failureCount >= 0 && failureCount <= 5) {
            failureCount++;
            throw new CallFailedException("CircuitBreaker error on call-count: '" + count + "', failureCount: '" + failureCount + "'");
        } else {
            failureCount = -1;
        }
    }

    public synchronized void reset() {
        count = 0;
        failureCount = -1;
    }
}
