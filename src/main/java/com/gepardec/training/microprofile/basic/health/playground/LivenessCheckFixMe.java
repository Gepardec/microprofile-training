package com.gepardec.training.microprofile.basic.health.playground;

import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import org.eclipse.microprofile.health.Liveness;
import javax.enterprise.context.ApplicationScoped;

@Liveness
@ApplicationScoped
public class LivenessCheckFixMe implements HealthCheck {
    @Override
    public HealthCheckResponse call() {
        return HealthCheckResponse.named("FixMeLive")
                                  .down()
                                  .build();
    }
}
