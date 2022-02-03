package com.gepardec.training.microprofile.basic.health;

import com.gepardec.training.microprofile.common.health.HealthHelper;
import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.Readiness;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Instance;
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
    @Readiness
    private Instance<HealthCheck> readinessChecks;

    @Inject
    private Models model;

    @Path("/")
    @GET
    @Controller
    public String getDatabaseLive() {

        if (healthHelper.healthCheckStateByName("Database", readinessChecks)) {
            model.put("stateMessage", "UP");
        } else {
            model.put("stateMessage", "DOWN");
        }

        if (healthHelper.databaseHealth()) {
            model.put("stateMessageDB", "UP");
        } else {
            model.put("stateMessageDB", "DOWN");
        }
        return "basic/health/database-ready.xhtml";
    }
}
