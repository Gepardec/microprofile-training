package com.gepardec.training.microprofile.basic.metrics;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class Sensor {

    public double readCurrentValue() {
        return Math.random();
    }
}
