package com.gepardec.training.microprofile;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Named;

@Named("mpUri")
@ApplicationScoped
public class MicroprofileSpecificationUri {

    private final String faultToleranceUri = "https://download.eclipse.org/microprofile/microprofile-fault-tolerance-3.0/microprofile-fault-tolerance-spec-3.0.html";

    private final String jwtUri = "https://download.eclipse.org/microprofile/microprofile-jwt-auth-1.2/microprofile-jwt-auth-spec-1.2.html";

    public String getFaultToleranceUri() {
        return faultToleranceUri;
    }

    public String getJwtUri() {
        return jwtUri;
    }
}
