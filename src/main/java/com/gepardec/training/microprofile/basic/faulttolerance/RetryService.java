package com.gepardec.training.microprofile.basic.faulttolerance;

import jakarta.enterprise.context.Dependent;
import org.eclipse.microprofile.faulttolerance.Retry;

@Dependent
public class RetryService {

    private int counter = 0;

    @Retry
    public int retried() {
        counter++;
        if (counter < 3) {
            throw new IllegalStateException("Failed, no retry :(");
        }

        return counter;
    }
}
