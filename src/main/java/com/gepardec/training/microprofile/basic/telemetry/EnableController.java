package com.gepardec.training.microprofile.basic.telemetry;

import jakarta.enterprise.context.RequestScoped;
import jakarta.mvc.Controller;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("/basic/telemetry/enable")
@RequestScoped
public class EnableController {


    @Controller
    @GET
    @Path("/")
    public String get() {
        return "basic/telemetry/enable.xhtml";
    }
}
