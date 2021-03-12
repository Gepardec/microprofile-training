package com.gepardec.training.microprofile;

import javax.enterprise.context.RequestScoped;
import javax.mvc.Controller;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/")
@RequestScoped
public class WelcomeController {

    @Path("/")
    @GET
    @Controller
    public String get() {
        return welcome();
    }

    @Path("/welcome")
    @GET
    @Controller
    public String welcome() {
        return "welcome.html";
    }
}
