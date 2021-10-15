package com.gepardec.training.microprofile.basic.metrics;

import org.omnifaces.cdi.Startup;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
@Startup
public class RandomNumberGenerator {

    public double getValue() {
        return Math.random();
    }

}
