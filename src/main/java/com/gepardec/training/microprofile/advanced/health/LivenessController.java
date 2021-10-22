package com.gepardec.training.microprofile.advanced.health;

import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
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
public class LivenessController {

    @Inject
    @Liveness
    private Instance<HealthCheck> livenessChecks;

    @Inject
    private Models model;

    @Path("/")
    @GET
    @Controller
    public String getLive() {
        if (getHealthCheckStateByName("FixMe", livenessChecks)) {
            model.put("stateMessage", "UP");
        } else {
            model.put("stateMessage", "DOWN");
        }
        return "advanced/health/cdiintegration.xhtml";
    }

    private boolean getHealthCheckStateByName(String nameOfHealthCheck, Instance<HealthCheck> healthChecks) {
        return healthChecks
                .stream()
                .filter(check -> check.call().getName().contentEquals(nameOfHealthCheck))
                .anyMatch(check -> check.call().getStatus().equals(HealthCheckResponse.Status.UP));
    }
}
