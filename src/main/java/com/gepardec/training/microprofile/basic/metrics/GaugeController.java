package com.gepardec.training.microprofile.basic.metrics;

import org.eclipse.microprofile.metrics.*;

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
    private MetricRegistry metricRegistry;

    @Inject
    private Models model;

    @Path("/gauge")
    @GET
    @Controller
    public String getGauge() {
        Gauge<?> gauge = metricRegistry.getGauge(new MetricID("gauge-example"));
        model.put("gauge", gauge != null ? gauge.getValue() : "Metric 'gauge-example' does not exist.");
        return "basic/metrics/gauge.xhtml";
    }

}
