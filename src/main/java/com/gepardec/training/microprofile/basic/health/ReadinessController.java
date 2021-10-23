package com.gepardec.training.microprofile.basic.health;

import com.gepardec.training.microprofile.common.health.HealthHelper;
import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.Readiness;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;
import javax.mvc.Controller;
import javax.mvc.Models;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/basic/health/ready")
@RequestScoped
public class ReadinessController {

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
    public String getReady() {
        if (healthHelper.healthCheckStateByName("FixMeReady", readinessChecks)) {
            model.put("stateMessage", "UP");
        } else {
            model.put("stateMessage", "DOWN");
        }
        return "basic/health/readiness.xhtml";
    }
}
