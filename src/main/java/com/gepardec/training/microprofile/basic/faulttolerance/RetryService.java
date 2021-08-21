package com.gepardec.training.microprofile.basic.faulttolerance;

import javax.enterprise.context.Dependent;

@Dependent
public class RetryService {

    private int counter = 0;

    public int retried() {
        counter++;
        if (counter < 3) {
            throw new IllegalStateException("Failed, no retry :(");
        }

        return counter;
    }
}
