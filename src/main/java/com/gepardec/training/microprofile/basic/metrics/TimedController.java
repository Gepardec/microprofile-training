package com.gepardec.training.microprofile.basic.metrics;

import org.apache.commons.lang3.time.DurationFormatUtils;
import org.eclipse.microprofile.metrics.MetricID;
import org.eclipse.microprofile.metrics.MetricRegistry;
import org.eclipse.microprofile.metrics.Timer;

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
public class TimedController {

    public static final String METRIC_ID = "timed-example";

    public static final String FORMAT = "s.SSS";

    /*@Inject
    private MetricRegistry metricRegistry;*/

    @Inject
    private Models model;

    @Path("/timed")
    @GET
    @Controller
    public String getTimed() {
        // TODO: fix
        /*Timer timed = metricRegistry.getTimer(new MetricID(METRIC_ID));
        if (timed != null) {
            model.put("time", DurationFormatUtils.formatDuration(timed.getElapsedTime().toMillis(), FORMAT));
        }*/
        return "basic/metrics/timed.xhtml";
    }

    @Path("/time")
    @POST
    @Produces(MediaType.TEXT_PLAIN)
    public Response time() throws InterruptedException {
        // TODO: fix
        /*Thread.sleep((long) (Math.random() * 1000));
        Timer timer = metricRegistry.getTimer(new MetricID(METRIC_ID));
        return Response.ok(
                        timer != null ? DurationFormatUtils.formatDuration(timer.getElapsedTime().toMillis(), FORMAT) : "Metric '" + METRIC_ID + "' does not exist.")
                .build();*/
        return Response.ok().build();
    }

}
