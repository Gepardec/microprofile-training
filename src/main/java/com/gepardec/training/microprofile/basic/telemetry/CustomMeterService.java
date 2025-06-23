package com.gepardec.training.microprofile.basic.telemetry;

import io.opentelemetry.api.metrics.LongCounter;
import io.opentelemetry.api.metrics.Meter;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class CustomMeterService {

    @Inject
    Meter meter;

    private LongCounter longCounter;

    @PostConstruct
    public void init() {
        longCounter = meter
                .counterBuilder("custom_meter")
                .setDescription("Number of my custom meter")
                .setUnit("1")
                .build();
    }

    public void countUp() {
        if (longCounter == null) {
            return;
        }
        longCounter.add(1);
    }
}
