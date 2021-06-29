package com.gepardec.training.microprofile.basic.health;

import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.Readiness;
import javax.enterprise.context.ApplicationScoped;

@Readiness
@ApplicationScoped
public class PreparedReadinessCheck implements HealthCheck {
    @Override
    public HealthCheckResponse call() {
        return HealthCheckResponse.named("someotherdata")
                                  .withData("data","0815")
                                  .up()
                                  .build();
    }
}
