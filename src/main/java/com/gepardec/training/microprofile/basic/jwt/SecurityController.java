package com.gepardec.training.microprofile.basic.jwt;

import javax.enterprise.context.RequestScoped;
import javax.mvc.Controller;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.SecurityContext;

@RequestScoped
@Path(("/basic/jwt/security"))
public class SecurityController {

    @Context
    SecurityContext securityContext;

    @Controller
    @GET
    @Path("/")
    public String get() {
        return "basic/jwt/security.xhtml";
    }

    @GET
    @Path("/admin")
    public Response admin() {
        if (securityContext.getUserPrincipal() == null || "training-user".equalsIgnoreCase(securityContext.getUserPrincipal().getName())) {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("training-user should not be able to access this method").build();
        }
        return Response.ok(":-)").build();
    }
}
