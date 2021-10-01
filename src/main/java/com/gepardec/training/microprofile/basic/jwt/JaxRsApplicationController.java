package com.gepardec.training.microprofile.basic.jwt;

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
        return Response.ok("\uD83D\uDE00").build();
    }
}
