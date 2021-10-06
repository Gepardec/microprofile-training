package com.gepardec.training.microprofile.basic.jwt;

import javax.enterprise.context.RequestScoped;
import javax.mvc.Controller;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

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
