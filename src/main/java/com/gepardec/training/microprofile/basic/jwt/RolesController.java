package com.gepardec.training.microprofile.basic.jwt;

import javax.enterprise.context.RequestScoped;
import javax.mvc.Controller;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

@RequestScoped
@Path(("/basic/jwt/roles"))
public class RolesController {

    @Context
    SecurityContext securityContext;

    @Controller
    @GET
    @Path("/")
    public String get() {
        return "basic/jwt/roles.xhtml";
    }

    @GET
    @Path("/secured")
    public Response secured() {
        if (securityContext.getUserPrincipal() == null || "training-user".equalsIgnoreCase(securityContext.getUserPrincipal().getName())) {
            return Response.status(Response.Status.BAD_REQUEST).entity("training-user should not be able to access this method").build();
        }
        return Response.ok("\uD83D\uDE0E").build();
    }
}
