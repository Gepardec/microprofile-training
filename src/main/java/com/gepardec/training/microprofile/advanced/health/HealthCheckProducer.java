package com.gepardec.training.microprofile.advanced.health;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Produces;
import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.Liveness;

@ApplicationScoped
public class HealthCheckProducer {

    @Produces
    @Liveness
    HealthCheck produceHealthCheck() {
        return () -> HealthCheckResponse.named("produced").up().build();
    }
}
