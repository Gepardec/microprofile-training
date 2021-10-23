package com.gepardec.training.microprofile.advanced.jwt;

import org.eclipse.microprofile.jwt.Claim;
import org.eclipse.microprofile.jwt.Claims;
import org.eclipse.microprofile.jwt.JsonWebToken;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

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
