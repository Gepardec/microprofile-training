package com.gepardec.training.microprofile.basic.jwt;

import jakarta.enterprise.context.RequestScoped;
import jakarta.mvc.Controller;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

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
    @Path("/mp-jwt-loaded")
    public Response mpJwtLoaded() {
        return Response.ok("\uD83D\uDE00").build();
    }
}
