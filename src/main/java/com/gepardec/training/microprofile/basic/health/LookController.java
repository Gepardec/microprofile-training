package com.gepardec.training.microprofile.basic.health;

import jakarta.enterprise.context.RequestScoped;
import jakarta.mvc.Controller;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("/basic/health/look")
@RequestScoped
public class LookController {

    @Path("/")
    @GET
    @Controller
    public String getLook() {
        return "basic/health/look.xhtml";
    }
}
