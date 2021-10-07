package com.gepardec.training.microprofile.basic.health;

import javax.enterprise.context.RequestScoped;
import javax.mvc.Controller;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/basic/health/ready")
@RequestScoped
public class ReadyController {

    @Path("/")
    @GET
    @Controller
    public String getReady() {
        return "basic/health/ready.xhtml";
    }
}
