package com.gepardec.training.microprofile.basic.metrics;

import org.eclipse.microprofile.metrics.Counter;
import org.eclipse.microprofile.metrics.Meter;
import org.eclipse.microprofile.metrics.MetricRegistry;
import org.eclipse.microprofile.metrics.Timer;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.mvc.Controller;
import javax.mvc.Models;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/basic/metrics")
@RequestScoped
@Controller
public class MPMetricsController {

    @Inject
    private MetricRegistry metricRegistry;

    @Inject
    private Models model;

    @Inject
    private Counter counter;

    @Path("/counted")
    @GET
    public String getCounted(){
        Counter change = metricRegistry.counter("count-example");
        model.put("count", change.getCount());
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
        Meter meter = metricRegistry.meter("metered-example");
        model.put("meter", meter.getOneMinuteRate());
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
        Timer timed = metricRegistry.timer("timed-example");
        model.put("time", timed.getOneMinuteRate());
        return "basic/metrics/timed.xhtml";
    }

    @Path("/time")
    @GET
    public String time() {
        return getTimed();
    }
}
