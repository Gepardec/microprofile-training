package com.gepardec.training.microprofile.advanced.health;

import com.gepardec.training.microprofile.common.health.HealthHelper;
import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.Liveness;

import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;
import javax.mvc.Controller;
import javax.mvc.Models;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

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
