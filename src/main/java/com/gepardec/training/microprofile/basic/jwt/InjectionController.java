package com.gepardec.training.microprofile.basic.jwt;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.mvc.Controller;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.jwt.Claim;
import org.eclipse.microprofile.jwt.Claims;
import org.eclipse.microprofile.jwt.JsonWebToken;

@RequestScoped
@Path(("/basic/jwt/injection"))
public class InjectionController {

    @Inject
    @Claim(standard = Claims.upn)
    String upn;

    @Inject
    JsonWebToken jsonWebToken;

    @Controller
    @GET
    @Path("/")
    public String get() {
        return "basic/jwt/injection.xhtml";
    }

    @GET
    @Path("/upn-jwt")
    public Response upn_jwt() {
        if (getUpnFromJwt() != null) {
            return Response.ok(formatUpn(getUpnFromJwt(), "jwt")).build();
        } else {
            return Response.status(Response.Status.BAD_REQUEST).entity("upn not found").build();
        }
    }

    @GET
    @Path("/upn-claim")
    public Response upn_claim() {
        if (upn != null) {
            return Response.ok(formatUpn(upn, "claim")).build();
        } else {
            return Response.status(Response.Status.BAD_REQUEST).entity("upn not found").build();
        }
    }

    private String getUpnFromJwt() {
        return jsonWebToken.getClaim(Claims.upn);
    }

    private String formatUpn(final String upn, String type) {
        return String.format("%s %s %s", upn, type, upn.contains("admin") ? "\uD83E\uDD78" : "\uD83D\uDC7B");
    }
}
