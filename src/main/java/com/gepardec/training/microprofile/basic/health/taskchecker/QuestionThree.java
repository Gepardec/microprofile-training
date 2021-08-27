package com.gepardec.training.microprofile.basic.health.taskchecker;

import org.eclipse.microprofile.health.HealthCheck;
import org.eclipse.microprofile.health.HealthCheckResponse;
import javax.enterprise.inject.Instance;

public class QuestionThree implements TaskChecker {

    @Override
    public Integer check(Integer questionKey, Object object) {
        boolean allUp = false;

        if(object != null) {

            Instance<HealthCheck> healthChecks = (Instance<HealthCheck>) object;

            allUp = healthChecks
                    .stream().allMatch(check -> check.call().getStatus()
                                                     .equals(HealthCheckResponse.Status.UP));
        }
        if (allUp) {
            return 1;
        } else {
            return 2;
        }
    }
}
