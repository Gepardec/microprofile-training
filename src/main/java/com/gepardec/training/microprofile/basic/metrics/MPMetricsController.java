package com.gepardec.training.microprofile.basic.metrics;

import javax.enterprise.context.RequestScoped;
import javax.mvc.Controller;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/basic/metrics")
@RequestScoped
@Controller
public class MPMetricsController {

    @Path("/enable")
    @GET
    public String isEnabled(){
        return "basic/metrics/enable.xhtml";
    }
}
