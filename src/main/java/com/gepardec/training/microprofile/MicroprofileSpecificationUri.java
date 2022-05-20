package com.gepardec.training.microprofile;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;

@Named("mpUri")
@ApplicationScoped
public class MicroprofileSpecificationUri {

    private static final String BASE_URI = "https://download.eclipse.org/microprofile";

    private static final String FAULT_TOLERANCE_URI = BASE_URI + "/microprofile-fault-tolerance-4.0/microprofile-fault-tolerance-spec-4.0.html";

    private static final String JWT_URI = BASE_URI + "/microprofile-jwt-auth-2.0/microprofile-jwt-auth-spec-2.0.html";

    private static final String CONFIG_URI = BASE_URI + "/microprofile-config-3.0/microprofile-config-spec-3.0.html";

    private static final String OPEN_API_URI = BASE_URI + "/microprofile-open-api-3.0/microprofile-openapi-spec-3.0.html";

    private static final String REST_CLIENT_URI = BASE_URI + "/microprofile-rest-client-3.0/microprofile-rest-client-spec-3.0.html";

    private static final String HEALTH_URI = BASE_URI + "/microprofile-health-4.0/microprofile-health-spec-4.0.html";

    private static final String METRICS_URI = BASE_URI + "/microprofile-metrics-4.0/microprofile-metrics-spec-4.0.html";

    private static final String OPEN_TRACING_URI = BASE_URI + "/microprofile-opentracing-3.0/microprofile-opentracing-spec-3.0.html";

    public String getFaultToleranceUri() {
        return FAULT_TOLERANCE_URI;
    }

    public String getJwtUri() {
        return JWT_URI;
    }

    public String getConfigUri() {
        return CONFIG_URI;
    }

    public String getHealthUri() {
        return HEALTH_URI;
    }

    public String getOpenApiUri() {
        return OPEN_API_URI;
    }

    public String getRestClientUri() {
        return REST_CLIENT_URI;
    }

    public String getMetricsUri() {
        return METRICS_URI;
    }

    public String getOpenTracingUri() {
        return OPEN_TRACING_URI;
    }
}
