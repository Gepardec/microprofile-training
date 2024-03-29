package com.gepardec.training.microprofile.basic.metrics;

import org.eclipse.microprofile.metrics.Meter;
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
public class MeteredController {

    public static final String METRIC_ID = "metered-example";

    @Inject
    private MetricRegistry metricRegistry;

    @Inject
    private Models model;

    @Path("/metered")
    @GET
    @Controller
    public String getMetered() {
        Meter meter = metricRegistry.getMeter(new MetricID(METRIC_ID));
        if (meter != null) {
            model.put("meter", meter.getOneMinuteRate());
        }
        return "basic/metrics/metered.xhtml";
    }

    @Path("/meter")
    @POST
    @Produces(MediaType.TEXT_PLAIN)
    public Response meter() throws InterruptedException {
        Thread.sleep((long) Math.random() * 100);
        Meter meter = metricRegistry.getMeter(new MetricID(METRIC_ID));
        return Response.ok(meter != null ? meter.getOneMinuteRate() : "Metric '" + METRIC_ID + "' does not exist.").build();
    }

}
