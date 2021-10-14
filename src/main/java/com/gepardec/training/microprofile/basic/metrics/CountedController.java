package com.gepardec.training.microprofile.basic.metrics;

import org.eclipse.microprofile.metrics.Counter;
import org.eclipse.microprofile.metrics.MetricID;
import org.eclipse.microprofile.metrics.MetricRegistry;

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

    public static final String METRIC_ID = "count-example";

    @Inject
    private MetricRegistry metricRegistry;

    @Inject
    private Models model;

    @Controller
    @Path("/counted")
    @GET
    public String getCounted() {
        Counter counter = metricRegistry.getCounter(new MetricID(METRIC_ID));
        if (counter != null) {
            model.put("count", counter != null ? counter.getCount() : "Metric '" + METRIC_ID + "' does not exist.");
        }
        return "basic/metrics/counted.xhtml";
    }

    @Path("/count")
    @POST
    @Produces(MediaType.TEXT_PLAIN)
    public Response count() {
        Counter change = metricRegistry.getCounter(new MetricID(METRIC_ID));
        return Response.ok(change != null ? change.getCount() : "Metric '" + METRIC_ID + "' does not exist.").build();
    }

}
