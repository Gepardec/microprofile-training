package com.gepardec.training.microprofile.basic.metrics;

import org.apache.commons.lang3.time.DurationFormatUtils;
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
public class SimplyTimedController {

    @Inject
    private MetricRegistry metricRegistry;

    @Inject
    private Models model;

    @Path("/simply-timed")
    @GET
    @Controller
    public String getSimplyTimed() {
        SimpleTimer simpleTimer = metricRegistry.getSimpleTimer(new MetricID("simply-timed-example"));
        if (simpleTimer != null) {
            model.put("time", DurationFormatUtils.formatDuration(simpleTimer.getElapsedTime().toMillis(), "s.SSS"));
        }
        return "basic/metrics/simply_timed.xhtml";
    }

    @Path("/simple-time")
    @POST
    @Produces(MediaType.TEXT_PLAIN)
    public Response simpleTime() throws InterruptedException {
        Thread.sleep((long) (Math.random() * 1000));
        SimpleTimer simpleTimer = metricRegistry.getSimpleTimer(new MetricID("simply-timed-example"));
        return Response.ok(simpleTimer != null ? DurationFormatUtils.formatDuration(simpleTimer.getElapsedTime().toMillis(), "s.SSS") : "0.000").build();
    }

}
