package com.gepardec.training.microprofile.basic.metrics;

import org.apache.commons.lang3.time.DurationFormatUtils;
import org.eclipse.microprofile.metrics.MetricID;
import org.eclipse.microprofile.metrics.MetricRegistry;
import org.eclipse.microprofile.metrics.SimpleTimer;

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
public class SimplyTimedController {

    public static final String METRIC_ID = "simply-timed-example";

    public static final String FORMAT = "s.SSS";

    @Inject
    private MetricRegistry metricRegistry;

    @Inject
    private Models model;

    @Path("/simply-timed")
    @GET
    @Controller
    public String getSimplyTimed() {
        SimpleTimer simpleTimer = metricRegistry.getSimpleTimer(new MetricID(METRIC_ID));
        if (simpleTimer != null) {
            model.put("time", DurationFormatUtils.formatDuration(simpleTimer.getElapsedTime().toMillis(), FORMAT));
        }
        return "basic/metrics/simply-timed.xhtml";
    }

    @Path("/simple-time")
    @POST
    @Produces(MediaType.TEXT_PLAIN)
    public Response simpleTime() throws InterruptedException {
        Thread.sleep((long) (Math.random() * 1000));
        SimpleTimer simpleTimer = metricRegistry.getSimpleTimer(new MetricID(METRIC_ID));
        return Response.ok(simpleTimer != null ? DurationFormatUtils.formatDuration(simpleTimer.getElapsedTime().toMillis(), FORMAT) :
                "Metric '" + METRIC_ID + "' does not exist.").build();
    }

}
