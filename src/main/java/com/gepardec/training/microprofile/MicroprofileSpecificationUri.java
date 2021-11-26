package com.gepardec.training.microprofile;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

@Named("mpUri")
@ApplicationScoped
public class MicroprofileSpecificationUri {

    private static final String FAULT_TOLERANCE_URI = "https://download.eclipse.org/microprofile/microprofile-fault-tolerance-3.0/microprofile-fault-tolerance-spec-3.0.html";

    private static final String JWT_URI = "https://download.eclipse.org/microprofile/microprofile-jwt-auth-1.2/microprofile-jwt-auth-spec-1.2.html";

    private static final String CONFIG_URI = "https://download.eclipse.org/microprofile/microprofile-config-2.0/microprofile-config-spec-2.0.html";

    private static final String OPEN_API_URI = "https://download.eclipse.org/microprofile/microprofile-open-api-2.0/microprofile-openapi-spec-2.0.html";

    private static final String REST_CLIENT_URI = "https://download.eclipse.org/microprofile/microprofile-rest-client-2.0/microprofile-rest-client-spec-2.0.html";

    private static final String HEALTH_URI = "https://download.eclipse.org/microprofile/microprofile-health-2.1/microprofile-health-spec.html";

    private static final String METRICS_URI = "https://download.eclipse.org/microprofile/microprofile-metrics-3.0/microprofile-metrics-spec-3.0.html";

    private static final String OPEN_TRACING_URI = "https://download.eclipse.org/microprofile/microprofile-opentracing-2.0/microprofile-opentracing-spec-2.0.html";

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
