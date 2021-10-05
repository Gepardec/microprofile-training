package com.gepardec.training.microprofile.basic.health.playground;

import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.Readiness;
import javax.enterprise.context.ApplicationScoped;

@Readiness
@ApplicationScoped
public class FixMeReadyCheck implements HealthCheck {
    @Override
    public HealthCheckResponse call() {

        return HealthCheckResponse.named("FixMeReady")
                                  .down()
                                  .build();
    }
}