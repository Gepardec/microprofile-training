package com.gepardec.training.microprofile.basic.health;

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

@Path("/basic/health/live")
@RequestScoped
public class LivenessController {

    @Inject
    private HealthHelper healthHelper;

    @Inject
    @Liveness
    private Instance<HealthCheck> livenessChecks;

    @Inject
    private Models model;

    @Path("/")
    @GET
    @Controller
    public String getLive() {
        if (healthHelper.healthCheckStateByName("LivenessCheck", livenessChecks)) {
            model.put("stateMessage", "UP");
        } else {
            model.put("stateMessage", "DOWN");
        }
        return "basic/health/liveness.xhtml";
    }
}
