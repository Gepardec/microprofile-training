package com.gepardec.training.microprofile.basic.metrics;

import org.apache.commons.lang3.time.DurationFormatUtils;
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
public class SimplyTimedController {

    public static final String METRIC_ID = "simply-timed-example";

    public static final String FORMAT = "s.SSS";

    /*@Inject
    private MetricRegistry metricRegistry;*/

    @Inject
    private Models model;

    @Path("/simply-timed")
    @GET
    @Controller
    public String getSimplyTimed() {
        // TODO: fix
        /*SimpleTimer simpleTimer = metricRegistry.getSimpleTimer(new MetricID(METRIC_ID));
        if (simpleTimer != null) {
            model.put("time", DurationFormatUtils.formatDuration(simpleTimer.getElapsedTime().toMillis(), FORMAT));
        }*/
        return "basic/metrics/simply-timed.xhtml";
    }

    @Path("/simple-time")
    @POST
    @Produces(MediaType.TEXT_PLAIN)
    public Response simpleTime() throws InterruptedException {
        // TODO: fix
        /*Thread.sleep((long) (Math.random() * 1000));
        SimpleTimer simpleTimer = metricRegistry.getSimpleTimer(new MetricID(METRIC_ID));
        return Response.ok(simpleTimer != null ? DurationFormatUtils.formatDuration(simpleTimer.getElapsedTime().toMillis(), FORMAT) :
                "Metric '" + METRIC_ID + "' does not exist.").build();*/
        return Response.ok().build();
    }

}
