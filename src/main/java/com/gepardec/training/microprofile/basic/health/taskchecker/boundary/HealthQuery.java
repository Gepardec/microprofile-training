package com.gepardec.training.microprofile.basic.health.taskchecker.boundary;

import org.eclipse.microprofile.rest.client.inject.RestClient;
import javax.inject.Inject;
import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;

public class HealthQuery {

    @Inject
    @RestClient
    HealthResourceClient healthResourceCLient;

    public HealthStatus query() {
        Jsonb jb = JsonbBuilder.create();
        return jb.fromJson(healthResourceCLient.healthStatus(),HealthStatus.class);
    }
}
