package com.gepardec.training.microprofile.basic.metrics;

import org.apache.commons.lang3.time.DurationFormatUtils;
import org.eclipse.microprofile.metrics.*;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.mvc.Controller;
import javax.mvc.Models;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/basic/metrics")
@RequestScoped
@Controller
public class ExampleController {

    @Inject
    private MetricRegistry metricRegistry;

    @Inject
    private Models model;

    @Inject
    private Counter counter;

    @Path("/counted")
    @GET
    public String getCounted(){
        // TODO make many calls
        Counter change = metricRegistry.getCounter(new MetricID("count-example"));
        if(change != null) {
            model.put("count", change.getCount());
        }
        return "basic/metrics/counted.xhtml";
    }

    @Path("/metric")
    @GET
    public String getMetric() {
        model.put("count", counter.getCount());
        return "basic/metrics/metric.xhtml";
    }

    @Path("/count")
    @GET
    public String count(){
        return getCounted();
    }

    @Path("/metered")
    @GET
    public String getMetered(){
        // TODO make many calls
        Meter meter = metricRegistry.getMeter(new MetricID("metered-example"));
        if(meter != null) {
            model.put("meter", meter.getOneMinuteRate());
        }
        return "basic/metrics/metered.xhtml";
    }

    @Path("/meter")
    @GET
    public String meter(){
        return getMetered();
    }

    @Path("/timed")
    @GET
    public String getTimed(){
        Timer timed = metricRegistry.getTimer(new MetricID("timed-example"));
        if(timed != null) {
            model.put("time", timed.getOneMinuteRate());
        }
        return "basic/metrics/timed.xhtml";
    }

    @Path("/time")
    @GET
    public String time() throws InterruptedException {
        Thread.sleep((long) Math.random() * 1000);
        return getTimed();
    }

    @Path("/simply-timed")
    @GET
    public String getSimplyTimed(){
        SimpleTimer timed = metricRegistry.getSimpleTimer(new MetricID("simply-timed-example"));
        if(timed != null) {
            model.put("count", timed.getCount());
            model.put("time", DurationFormatUtils.formatDuration(timed.getElapsedTime().toMillis(), "s.SSS"));
        }
        return "basic/metrics/simply_timed.xhtml";
    }

    @Path("/simple-time")
    @GET
    public String simpleTime() throws InterruptedException {
        Thread.sleep((long) Math.random() * 1000);
        return getSimplyTimed();
    }
}
