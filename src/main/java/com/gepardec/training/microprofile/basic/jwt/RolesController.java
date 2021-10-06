package com.gepardec.training.microprofile.basic.jwt;

import javax.annotation.security.DenyAll;
import javax.annotation.security.PermitAll;
import javax.enterprise.context.RequestScoped;
import javax.mvc.Controller;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

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
