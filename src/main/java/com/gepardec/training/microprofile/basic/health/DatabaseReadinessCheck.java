package com.gepardec.training.microprofile.basic.health;

import com.gepardec.training.microprofile.common.health.HealthHelper;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.Readiness;

import java.time.LocalDateTime;

@Readiness
@ApplicationScoped
public class DatabaseReadinessCheck implements HealthCheck {

    @Inject
    HealthHelper healthHelper;

    HealthCheckResponse lastHealthCheckResponse;
    LocalDateTime lastHealthCheckTime;

    @Override
    public HealthCheckResponse call() {
        final var now = LocalDateTime.now();
        if (lastHealthCheckResponse == null || lastHealthCheckTime.isBefore(now.minusSeconds(30))) {
            final var healthCheckResponseBuilder = HealthCheckResponse.named("Database");
            if (healthHelper.databaseHealth()) {
                lastHealthCheckResponse = healthCheckResponseBuilder.up().build();
            } else {
                lastHealthCheckResponse = healthCheckResponseBuilder.down().build();
            }
            lastHealthCheckTime = now;
        }
        return lastHealthCheckResponse;
    }
}
