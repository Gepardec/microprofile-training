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
        return  Response.ok(change.getCount()).build();
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
        // TODO make many calls
        Meter meter = metricRegistry.getMeter(new MetricID("metered-example"));
        if (meter != null) {
            model.put("meter", meter.getOneMinuteRate());
        }
        return "basic/metrics/metered.xhtml";
    }

    @Path("/meter")
    @GET
    @Controller
    public String meter(){
        return getMetered();
    }

    @Path("/timed")
    @GET
    @Controller
    public String getTimed() {
        Timer timed = metricRegistry.getTimer(new MetricID("timed-example"));
        if (timed != null) {
            DecimalFormat format = new DecimalFormat("#0.000", new DecimalFormatSymbols(Locale.ENGLISH));
            model.put("time", DurationFormatUtils.formatDuration(timed.getElapsedTime().toMillis(), "s.SSS"));
            model.put("rate", format.format(timed.getOneMinuteRate()));
        }
        return "basic/metrics/timed.xhtml";
    }

    @Path("/time")
    @GET
    @Controller
    public String time() throws InterruptedException {
        Thread.sleep((long) Math.random() * 1000);
        return getTimed();
    }

    @Path("/simply-timed")
    @GET
    @Controller
    public String getSimplyTimed() {
        SimpleTimer timed = metricRegistry.getSimpleTimer(new MetricID("simply-timed-example"));
        if (timed != null) {
            model.put("count", timed.getCount());
            model.put("time", DurationFormatUtils.formatDuration(timed.getElapsedTime().toMillis(), "s.SSS"));
        }
        return "basic/metrics/simply_timed.xhtml";
    }

    @Path("/simple-time")
    @GET
    @Controller
    public String simpleTime() throws InterruptedException {
        Thread.sleep((long) Math.random() * 1000);
        return getSimplyTimed();
    }
}
