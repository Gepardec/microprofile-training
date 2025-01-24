package com.gepardec.training.microprofile.basic.metrics;

import org.eclipse.microprofile.metrics.Counter;
import org.eclipse.microprofile.metrics.MetricID;
import org.eclipse.microprofile.metrics.MetricRegistry;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.mvc.Controller;
import jakarta.mvc.Models;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@Path("/basic/metrics")
@RequestScoped
public class CountedController {

    public static final String METRIC_ID = "count-example";

    /*@Inject
    private MetricRegistry metricRegistry;*/

    @Inject
    private Models model;

    @Controller
    @Path("/counted")
    @GET
    public String getCounted() {
        // TODO: fix
        /*Counter counter = metricRegistry.getCounter(new MetricID(METRIC_ID));
        model.put("count", counter != null ? counter.getCount() : "Metric '" + METRIC_ID + "' does not exist.");*/
        return "basic/metrics/counted.xhtml";
    }

    @Path("/count")
    @POST
    @Produces(MediaType.TEXT_PLAIN)
    public Response count() {
        //TODO: fix
        /*Counter change = metricRegistry.getCounter(new MetricID(METRIC_ID));
        return Response.ok(change != null ? change.getCount() : "Metric '" + METRIC_ID + "' does not exist.").build();*/
        return Response.ok().build();
    }

}
