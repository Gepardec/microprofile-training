package com.gepardec.training.microprofile.basic.metrics;

import org.eclipse.microprofile.metrics.*;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.mvc.Controller;
import javax.mvc.Models;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/basic/metrics")
@RequestScoped
public class CountedController {

    @Inject
    private MetricRegistry metricRegistry;

    @Inject
    private Models model;

    @Controller
    @Path("/counted")
    @GET
    public String getCounted() {
        Counter counter = metricRegistry.getCounter(new MetricID("count-example"));
        if (counter != null) {
            model.put("count", counter != null ? counter.getCount() : "Metric 'count-example' does not exist.");
        }
        return "basic/metrics/counted.xhtml";
    }

    @Path("/count")
    @POST
    @Produces(MediaType.TEXT_PLAIN)
    public Response count() {
        Counter change = metricRegistry.getCounter(new MetricID("count-example"));
        return Response.ok(change != null ? change.getCount() : "Metric 'count-example' does not exist.").build();
    }


}
