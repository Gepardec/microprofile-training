package com.gepardec.training.microprofile.basic.metrics;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class RandomNumberGenerator {

    public double getValue() {
        return Math.random();
    }

}
