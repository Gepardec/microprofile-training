package com.gepardec.training.microprofile.advanced.jwt;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.jwt.Claim;
import org.eclipse.microprofile.jwt.Claims;
import org.eclipse.microprofile.jwt.JsonWebToken;

@ApplicationScoped
public class InjectionProxyingService {

    @Inject
    @Claim(standard = Claims.upn)
    private String upn;

    @Inject
    private JsonWebToken jsonWebToken;

    public boolean isUpnValid() {
        return jsonWebToken.getClaim(Claims.upn).equals(upn);
    }
}
