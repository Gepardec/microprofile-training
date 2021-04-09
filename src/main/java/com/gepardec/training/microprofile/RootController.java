package com.gepardec.training.microprofile;

import javax.enterprise.context.RequestScoped;
import javax.mvc.Controller;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/")
@RequestScoped
@Controller
public class RootController {

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

    @Path("/index")
    @GET
    public String index() {
        return "index.xhtml";
    }
}
