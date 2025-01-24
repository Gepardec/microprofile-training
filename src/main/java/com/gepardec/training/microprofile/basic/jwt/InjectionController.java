package com.gepardec.training.microprofile.basic.jwt;

import jakarta.enterprise.context.RequestScoped;
import jakarta.mvc.Controller;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

@RequestScoped
@Path(("/basic/jwt/injection"))
public class InjectionController {

    String upn;

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
            return Response.ok(formatUpn(getUpnFromJwt())).build();
        } else {
            return Response.status(Response.Status.BAD_REQUEST).entity("upn not found").build();
        }
    }

    @GET
    @Path("/upn-claim")
    public Response upn_claim() {
        if (upn != null) {
            return Response.ok(formatUpn(upn)).build();
        } else {
            return Response.status(Response.Status.BAD_REQUEST).entity("upn not found").build();
        }
    }

    private String getUpnFromJwt() {
        return null;
    }

    private String formatUpn(final String upn) {
        return String.format("%s %s", upn, upn.contains("admin") ? "\uD83E\uDD78" : "\uD83D\uDC7B");
    }
}
