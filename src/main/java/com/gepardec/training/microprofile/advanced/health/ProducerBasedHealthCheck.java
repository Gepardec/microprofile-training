package com.gepardec.training.microprofile.advanced.health;

import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.Liveness;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;

@ApplicationScoped
public class ProducerBasedHealthCheck {

    @Liveness
    @Produces
    public HealthCheck produceLivenessCheck() {
        return () -> HealthCheckResponse.named("produced").up().build();
    }
}
