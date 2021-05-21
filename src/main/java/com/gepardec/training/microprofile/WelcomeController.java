package com.gepardec.training.microprofile;

import javax.enterprise.context.RequestScoped;
import javax.mvc.Controller;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

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
