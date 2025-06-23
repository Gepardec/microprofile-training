package com.gepardec.training.microprofile.basic.jwt;

import jakarta.enterprise.context.RequestScoped;
import jakarta.mvc.Controller;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

@RequestScoped
@Path(("/basic/jwt/configuration"))
public class ConfigurationController {

    @Controller
    @GET
    @Path("/")
    public String get() {
        return "basic/jwt/configuration.xhtml";
    }

    @GET
    @Path("/config-loaded")
    public Response configLoaded() {
        return Response.ok("\uD83D\uDE01").build();
    }
}
