package com.gepardec.training.microprofile.basic.metrics;

import org.eclipse.microprofile.metrics.Counter;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.mvc.Controller;
import jakarta.mvc.Models;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("/basic/metrics")
@RequestScoped
public class MetricController {

    @Inject
    private Models model;

    /*@Inject
    private Counter counter;*/

    @Path("/metric")
    @GET
    @Controller
    public String getMetric() {
        // TODO: fix
        /*model.put("count", counter.getCount());*/
        return "basic/metrics/metric.xhtml";
    }

}
