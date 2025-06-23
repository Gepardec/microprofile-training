package com.gepardec.training.microprofile.advanced.openapi;

import jakarta.enterprise.context.RequestScoped;
import jakarta.mvc.Controller;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("/advanced/openapi/generatesources")
@RequestScoped
public class GenerateSourcesController {

    @Path("/")
    @GET
    @Controller
    public String getGenerateSources() {
        return "advanced/openapi/generatesources.xhtml";
    }
}
