package com.gepardec.training.microprofile.basic.health;

import com.gepardec.training.microprofile.common.health.HealthHelper;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.mvc.Controller;
import javax.mvc.Models;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/basic/health/database-ready")
@RequestScoped
public class DatabaseReadinessController {

    @Inject
    private HealthHelper healthHelper;

    @Inject
    private Models model;

    @Path("/")
    @GET
    @Controller
    public String getDatabaseReady() {
        model.put("readinessCheckResults", healthHelper.getReadinessChecks());
        model.put("stateMessageDB", healthHelper.databaseHealth() ? "UP" : "DOWN");
        return "basic/health/database-ready.xhtml";
    }
}
