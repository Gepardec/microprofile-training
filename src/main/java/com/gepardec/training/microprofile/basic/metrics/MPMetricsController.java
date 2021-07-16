package com.gepardec.training.microprofile.basic.metrics;

import org.eclipse.microprofile.metrics.Counter;
import org.eclipse.microprofile.metrics.MetricRegistry;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.mvc.Controller;
import javax.mvc.Models;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/basic/metrics")
@RequestScoped
@Controller
public class MPMetricsController {

    @Inject
    private MetricRegistry metricRegistry;

    @Inject
    private Models model;

    @Path("/enable")
    @GET
    public String isEnabled(){
        return "basic/metrics/enable.xhtml";
    }

    @Path("/counted")
    @GET
    public String getCounted(){
        Counter change = metricRegistry.counter("count-example");
        model.put("count", change.getCount());
        return "basic/metrics/counted.xhtml";
    }

    @Path("/count")
    @GET
    public String count(){
        return getCounted();
    }

}
