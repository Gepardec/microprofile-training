package com.gepardec.training.microprofile.basic.telemetry;

import io.opentelemetry.api.metrics.LongCounter;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class CustomMeterService {

    private LongCounter longCounter;

    public void countUp() {
        if (longCounter == null) {
            return;
        }
        longCounter.add(1);
    }
}
