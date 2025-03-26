package com.gepardec.training.microprofile;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Named;

@Named("mpUri")
@ApplicationScoped
public class MicroprofileSpecificationUri {

    private static final String CONFIG_URI = "https://download.eclipse.org/microprofile/microprofile-config-3.1/microprofile-config-spec-3.1.html";

    private static final String FAULT_TOLERANCE_URI = "https://download.eclipse.org/microprofile/microprofile-fault-tolerance-4.1/microprofile-fault-tolerance-spec-4.1.html";

    private static final String HEALTH_URI = "https://download.eclipse.org/microprofile/microprofile-health-4.0.1/microprofile-health-spec-4.0.1.html";

    private static final String TELEMETRY_URI = "https://download.eclipse.org/microprofile/microprofile-telemetry-2.0/microprofile-telemetry-spec-2.0.html";

    private static final String OPEN_API_URI = "https://download.eclipse.org/microprofile/microprofile-open-api-4.0/microprofile-openapi-spec-4.0.html";

    private static final String JWT_AUTHENTICATION_URI = "https://download.eclipse.org/microprofile/microprofile-jwt-auth-2.1/microprofile-jwt-auth-spec-2.1.html";

    private static final String REST_CLIENT_URI = "https://download.eclipse.org/microprofile/microprofile-rest-client-4.0/microprofile-rest-client-spec-4.0.html";

    public String getConfigUri() {
        return CONFIG_URI;
    }

    public String getFaultToleranceUri() {
        return FAULT_TOLERANCE_URI;
    }

    public String getHealthUri() {
        return HEALTH_URI;
    }

    public String getTelemetryUri() {
        return TELEMETRY_URI;
    }

    public String getOpenApiUri() {
        return OPEN_API_URI;
    }

    public String getJwtAuthenticationUri() {
        return JWT_AUTHENTICATION_URI;
    }

    public String getRestClientUri() {
        return REST_CLIENT_URI;
    }
}
