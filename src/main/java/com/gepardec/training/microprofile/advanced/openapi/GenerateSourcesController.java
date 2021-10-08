package com.gepardec.training.microprofile.advanced.openapi;

import javax.enterprise.context.RequestScoped;
import javax.mvc.Controller;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

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
