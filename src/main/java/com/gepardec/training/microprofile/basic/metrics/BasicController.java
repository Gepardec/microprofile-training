package com.gepardec.training.microprofile.basic.metrics;

import jakarta.enterprise.context.RequestScoped;
import jakarta.mvc.Controller;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("/basic/metrics")
@RequestScoped
public class BasicController {

    @Controller
    @Path("/base")
    @GET
    public String getBase() {
        return "basic/metrics/base.xhtml";
    }

}
