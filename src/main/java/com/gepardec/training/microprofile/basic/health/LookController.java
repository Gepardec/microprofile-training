package com.gepardec.training.microprofile.basic.health;

import javax.enterprise.context.RequestScoped;
import javax.mvc.Controller;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

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
