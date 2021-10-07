package com.gepardec.training.microprofile.basic.health;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.mvc.Controller;
import javax.mvc.Models;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/basic/health/ready")
@RequestScoped
public class ReadyController {

    @Inject
    private Models model;

    @Path("/")
    @GET
    @Controller
    public String getReady() {
        if (getHealthCheckStateByName("FixMe", "Readiness")) {
            model.put("State", "UP");
        } else {
            model.put("State", "DOWN");
        }
        return "basic/health/ready.xhtml";
    }

    private boolean getHealthCheckStateByName(String fixMe, String readiness) {
        return true;
    }
}
