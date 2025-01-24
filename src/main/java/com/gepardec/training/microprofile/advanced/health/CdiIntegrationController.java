package com.gepardec.training.microprofile.advanced.health;

import com.gepardec.training.microprofile.common.health.HealthHelper;
import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.Liveness;

import jakarta.enterprise.context.RequestScoped;
import jakarta.enterprise.inject.Instance;
import jakarta.inject.Inject;
import jakarta.mvc.Controller;
import jakarta.mvc.Models;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("/advanced/health/cdiintegration")
@RequestScoped
public class CdiIntegrationController {

    @Inject
    private HealthHelper healthHelper;

    @Inject
    private Models model;

    @Path("/")
    @GET
    @Controller
    public String getLive() {
        model.put("livenessCheckResults", healthHelper.getLivenessChecks());
        return "advanced/health/cdiintegration.xhtml";
    }

}
