package com.gepardec.training.microprofile.basic.health.taskchecker;

import com.gepardec.training.microprofile.basic.health.taskchecker.boundary.HealthQuery;
import com.gepardec.training.microprofile.basic.health.taskchecker.boundary.HealthStatus;

public class QuestionThree implements TaskChecker{
    @Override
    public Integer check(Integer questionKey) {
        boolean works = false;

        HealthQuery healthQuery = new HealthQuery();
        HealthStatus healthStatus = healthQuery.query();
        
        works = Boolean.getBoolean(healthStatus.status);

        if (works) {return 1;}
        return 2;
    }
}
