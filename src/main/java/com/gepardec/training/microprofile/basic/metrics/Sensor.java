package com.gepardec.training.microprofile.basic.metrics;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class Sensor {

    public double readCurrentValue() {
        return Math.random();
    }
}
