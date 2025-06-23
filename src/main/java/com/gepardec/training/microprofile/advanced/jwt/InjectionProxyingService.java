package com.gepardec.training.microprofile.advanced.jwt;

import org.eclipse.microprofile.jwt.Claim;
import org.eclipse.microprofile.jwt.ClaimValue;
import org.eclipse.microprofile.jwt.Claims;
import org.eclipse.microprofile.jwt.JsonWebToken;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class InjectionProxyingService {

    @Inject
    @Claim(standard = Claims.upn)
    private ClaimValue<String> upn;

    @Inject
    private JsonWebToken jsonWebToken;

    public boolean isUpnValid() {
        return jsonWebToken.getClaim(Claims.upn).equals(upn.getValue());
    }
}
