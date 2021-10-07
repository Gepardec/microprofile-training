package com.gepardec.training.microprofile.basic.health;

import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.Readiness;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Any;
import javax.enterprise.inject.Instance;
import javax.inject.Inject;
import javax.mvc.Controller;
import javax.mvc.Models;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.lang.annotation.Annotation;

@Path("/basic/health/ready")
@RequestScoped
public class ReadyController {

    @Inject
    @Any
    Instance<HealthCheck> healthChecks;

    @Inject
    private Models model;

    @Path("/")
    @GET
    @Controller
    public String getReady() {
        if (getHealthCheckStateByNameAndAnnotation("FixMe", Readiness.class)) {
            model.put("stateMessage", "UP");
        } else {
            model.put("stateMessage", "DOWN");
        }
        return "basic/health/ready.xhtml";
    }

    private boolean getHealthCheckStateByNameAndAnnotation(String nameOfHealthCheck, Class<? extends Annotation> healthCheckAnnotation) {
        return healthChecks
                        .stream()
                        .filter(check -> check.call().getName().contentEquals(nameOfHealthCheck))
                        .filter(check -> check.getClass().isAnnotationPresent(healthCheckAnnotation))
                        .anyMatch(readinessCheck -> readinessCheck.call().getStatus().equals(HealthCheckResponse.Status.UP));
    }
}
