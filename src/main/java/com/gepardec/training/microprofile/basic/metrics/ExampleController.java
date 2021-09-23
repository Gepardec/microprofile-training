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
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

@Path("/basic/metrics")
@RequestScoped
public class ExampleController {

    @Inject
    private MetricRegistry metricRegistry;

    @Inject
    private Models model;

    @Inject
    private Counter counter;

    @Controller
    @Path("/base")
    @GET
    public String getBase() {
        return "basic/metrics/base.xhtml";
    }

    @Controller
    @Path("/counted")
    @GET
    public String getCounted() {
        Counter change = metricRegistry.getCounter(new MetricID("count-example"));
        if (change != null) {
            model.put("count", change.getCount());
        }
        return "basic/metrics/counted.xhtml";
    }

    @Path("/count")
    @POST
    @Produces(MediaType.TEXT_PLAIN)
    public Response count() {
        Counter change = metricRegistry.getCounter(new MetricID("count-example"));
        return Response.ok(change.getCount()).build();
    }

    @Path("/metric")
    @GET
    @Controller
    public String getMetric() {
        model.put("count", counter.getCount());
        return "basic/metrics/metric.xhtml";
    }

    @Path("/metered")
    @GET
    @Controller
    public String getMetered() {
        Meter meter = metricRegistry.getMeter(new MetricID("metered-example"));
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
        Meter meter = metricRegistry.getMeter(new MetricID("metered-example"));
        return Response.ok(meter != null ? meter.getOneMinuteRate() : "0").build();
    }

    @Path("/timed")
    @GET
    @Controller
    public String getTimed() {
        Timer timed = metricRegistry.getTimer(new MetricID("timed-example"));
        if (timed != null) {
            DecimalFormat format = new DecimalFormat("#0.000", new DecimalFormatSymbols(Locale.ENGLISH));
            model.put("time", DurationFormatUtils.formatDuration(timed.getElapsedTime().toMillis(), "s.SSS"));
        }
        return "basic/metrics/timed.xhtml";
    }

    @Path("/time")
    @POST
    @Produces(MediaType.TEXT_PLAIN)
    public Response time() throws InterruptedException {
        Thread.sleep((long) (Math.random() * 1000));
        Timer timer = metricRegistry.getTimer(new MetricID("timed-example"));
        return Response.ok(timer != null ? DurationFormatUtils.formatDuration(timer.getElapsedTime().toMillis(), "s.SSS") : "0.000").build();
    }

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
