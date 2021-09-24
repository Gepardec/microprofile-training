package com.gepardec.training.microprofile.basic.jwt;

import org.eclipse.microprofile.jwt.JsonWebToken;

import javax.enterprise.context.RequestScoped;
import javax.mvc.Controller;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;


@RequestScoped
@Path(("/basic/jwt/jaxrs-application"))
public class JaxRsApplicationController {

    @Controller
    @GET
    @Path("/")
    public String get() {
        return "basic/jwt/jaxrs-application.xhtml";
    }

    @GET
    @Path("/jwt-loaded")
    public Response jwtLoaded() {
        if (isMpJwtLoaded()) {
            return Response.ok(":-)").build();
        } else {
            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("MicroProfile JWT not loaded").build();
        }
    }

    private boolean isMpJwtLoaded() {
        try {
            Class.forName(JsonWebToken.class.getName());
            return true;
        } catch (NoClassDefFoundError | ClassNotFoundException e) {
            return false;
        }
    }
}
