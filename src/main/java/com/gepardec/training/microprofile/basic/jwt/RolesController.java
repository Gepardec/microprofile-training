package com.gepardec.training.microprofile.basic.jwt;

import jakarta.annotation.security.DenyAll;
import jakarta.annotation.security.PermitAll;
import jakarta.enterprise.context.RequestScoped;
import jakarta.mvc.Controller;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.SecurityContext;

@RequestScoped
@Path(("/basic/jwt/roles"))
@DenyAll
public class RolesController {

    @Context
    private SecurityContext securityContext;

    @Controller
    @GET
    @Path("/")
    @PermitAll
    public String get() {
        return "basic/jwt/roles.xhtml";
    }

    @GET
    @Path("/secured")
    public Response secured() {
        return Response.ok("\uD83E\uDD2B").build();
    }
}
