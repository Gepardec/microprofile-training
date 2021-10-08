package com.gepardec.training.microprofile.basic.metrics;

import org.apache.commons.lang3.time.DurationFormatUtils;
import org.eclipse.microprofile.metrics.MetricID;
import org.eclipse.microprofile.metrics.MetricRegistry;
import org.eclipse.microprofile.metrics.Timer;

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
public class TimedController {

    public static final String METRIC_ID = "timed-example";

    public static final String FORMAT = "s.SSS";

    @Inject
    private MetricRegistry metricRegistry;

    @Inject
    private Models model;

    @Path("/timed")
    @GET
    @Controller
    public String getTimed() {
        Timer timed = metricRegistry.getTimer(new MetricID(METRIC_ID));
        if (timed != null) {
            model.put("time", DurationFormatUtils.formatDuration(timed.getElapsedTime().toMillis(), FORMAT));
        }
        return "basic/metrics/timed.xhtml";
    }

    @Path("/time")
    @POST
    @Produces(MediaType.TEXT_PLAIN)
    public Response time() throws InterruptedException {
        Thread.sleep((long) (Math.random() * 1000));
        Timer timer = metricRegistry.getTimer(new MetricID(METRIC_ID));
        return Response.ok(
                        timer != null ? DurationFormatUtils.formatDuration(timer.getElapsedTime().toMillis(), FORMAT) : "Metric '" + METRIC_ID + "' does not exist.")
                .build();
    }

}
