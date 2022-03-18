package com.gepardec.training.microprofile.basic.metrics;

import org.eclipse.microprofile.metrics.Gauge;
import org.eclipse.microprofile.metrics.MetricID;
import org.eclipse.microprofile.metrics.MetricRegistry;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.mvc.Controller;
import javax.mvc.Models;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

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
