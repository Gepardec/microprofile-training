package com.gepardec.training.microprofile.basic.health;

import com.gepardec.training.microprofile.common.health.HealthHelper;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.mvc.Controller;
import jakarta.mvc.Models;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("/basic/health/live")
@RequestScoped
public class LivenessController {

    @Inject
    private HealthHelper healthHelper;

    @Inject
    private Models model;

    @Path("/")
    @GET
    @Controller
    public String getLive() {
        model.put("livenessCheckResults", healthHelper.getLivenessChecks());
        return "basic/health/liveness.xhtml";
    }
}
