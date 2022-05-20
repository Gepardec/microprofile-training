package com.gepardec.training.microprofile.basic.metrics;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.mvc.Controller;
import jakarta.mvc.Models;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import org.eclipse.microprofile.metrics.Counter;

@Path("/basic/metrics")
@RequestScoped
public class MetricController {

    @Inject
    private Models model;

    @Inject
    private Counter counter;

    @Path("/metric")
    @GET
    @Controller
    public String getMetric() {
        model.put("count", counter.getCount());
        return "basic/metrics/metric.xhtml";
    }

}
