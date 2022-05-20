package com.gepardec.training.microprofile;

import jakarta.enterprise.context.RequestScoped;
import jakarta.mvc.Controller;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("/")
@RequestScoped
@Controller
public class WelcomeController {

    @Path("/")
    @GET
    public String root() {
        return welcome();
    }

    @Path("/welcome")
    @GET
    public String welcome() {
        return "welcome.xhtml";
    }
}
