package com.gepardec.training.microprofile.basic.health;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.mvc.Controller;
import javax.mvc.Models;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/basic/health")
@RequestScoped
@Controller
public class HealthController {

    @Inject
    Models models;

    @Inject
    HealthState healthState;

    @Path("/")
    @GET
    public String get() {
        return index();
    }

    @Path("/index")
    @GET
    public String index() {
        models.put("healthState",healthState);
        return "basic/health/index.xhtml";
    }

}
