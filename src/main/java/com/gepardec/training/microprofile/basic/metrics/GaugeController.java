package com.gepardec.training.microprofile.basic.metrics;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.mvc.Controller;
import jakarta.mvc.Models;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import org.eclipse.microprofile.metrics.Gauge;
import org.eclipse.microprofile.metrics.MetricID;
import org.eclipse.microprofile.metrics.MetricRegistry;

@Path("/basic/metrics")
@RequestScoped
public class GaugeController {

    @Inject
    private Sensor sensor;

    @Inject
    private MetricRegistry metricRegistry;

    @Inject
    private Models model;

    @PostConstruct
    void init() {
        sensor.readCurrentValue();
    }

    @Path("/gauge")
    @GET
    @Controller
    public String getGauge() {
        Gauge<?> gauge = metricRegistry.getGauge(new MetricID("gauge-example"));
        model.put("gauge", gauge != null ? gauge.getValue() : "Metric 'gauge-example' does not exist.");
        return "basic/metrics/gauge.xhtml";
    }

}
