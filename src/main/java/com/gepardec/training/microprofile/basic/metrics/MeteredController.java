package com.gepardec.training.microprofile.basic.metrics;

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
public class MeteredController {

    public static final String METRIC_ID = "metered-example";

    /*@Inject
    private MetricRegistry metricRegistry;*/

    @Inject
    private Models model;

    @Path("/metered")
    @GET
    @Controller
    public String getMetered() {
        // TODO: fix
        /*Meter meter = metricRegistry.getMeter(new MetricID(METRIC_ID));
        if (meter != null) {
            model.put("meter", meter.getOneMinuteRate());
        }*/
        return "basic/metrics/metered.xhtml";
    }

    @Path("/meter")
    @POST
    @Produces(MediaType.TEXT_PLAIN)
    public Response meter() throws InterruptedException {
        // TODO: fix
        Thread.sleep((long) Math.random() * 100);
        /*Meter meter = metricRegistry.getMeter(new MetricID(METRIC_ID));
        return Response.ok(meter != null ? meter.getOneMinuteRate() : "Metric '" + METRIC_ID + "' does not exist.").build();*/
        return Response.ok().build();
    }

}
