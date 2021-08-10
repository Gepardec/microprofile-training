package com.gepardec.training.microprofile.basic.faulttolerance;

import org.eclipse.microprofile.faulttolerance.Retry;

import javax.enterprise.context.Dependent;
import java.time.temporal.ChronoUnit;

@Dependent
public class RetryService {

    private int counter = 0;

    public int retried() {
        counter++;
        if (counter < 3) {
            throw new IllegalStateException("Hve to fail because counter is still to low");
        }

        return counter;
    }
}
