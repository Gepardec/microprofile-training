package com.gepardec.training.microprofile.basic.health;

import com.gepardec.training.microprofile.common.health.HealthHelper;
import org.apache.commons.lang3.time.StopWatch;
import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.HealthCheckResponseBuilder;
import org.eclipse.microprofile.health.Readiness;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@Readiness
@ApplicationScoped
public class DatabaseReadinessCheck implements HealthCheck {

    @Inject
    private HealthHelper healthHelper;

    private boolean databaseHealth;
    private StopWatch stopWatch;

    @Override
    public HealthCheckResponse call() {
        return cachedDatabaseHealthCheck();
    }

    private HealthCheckResponse simpleDatabaseHealthCheck() {
        return createDatabaseHealthCheck(healthHelper.databaseHealth());
    }

    private HealthCheckResponse cachedDatabaseHealthCheck() {
        if (stopWatch == null) {
            databaseHealth = healthHelper.databaseHealth();
            stopWatch = new StopWatch();
            stopWatch.start();
        }

        stopWatch.split();

        if (stopWatch.getSplitTime() > 30000L) {
            databaseHealth = healthHelper.databaseHealth();
            stopWatch.reset();
            stopWatch.start();
        }
        return createDatabaseHealthCheck(databaseHealth);
    }

    private HealthCheckResponse createDatabaseHealthCheck(final boolean databaseHealth) {
        final HealthCheckResponseBuilder healthCheckResponseBuilder = HealthCheckResponse.named("Database");
        if (databaseHealth) {
            healthCheckResponseBuilder.up();
        } else {
            healthCheckResponseBuilder.down();
        }
        return healthCheckResponseBuilder.build();
    }
}
