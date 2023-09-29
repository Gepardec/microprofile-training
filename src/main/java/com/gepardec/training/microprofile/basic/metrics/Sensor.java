package com.gepardec.training.microprofile.basic.metrics;

import org.eclipse.microprofile.metrics.MetricUnits;
import org.eclipse.microprofile.metrics.annotation.Gauge;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class Sensor {

    @Gauge(name = "gauge-example", absolute = true, unit = MetricUnits.NONE)
    public double readCurrentValue() {
        return Math.random();
    }
}
