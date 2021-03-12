package com.gepardec.training.microprofile;

import javax.enterprise.context.RequestScoped;
import javax.mvc.Controller;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/")
@RequestScoped
public class IndexController {

    @Path("/index")
    @GET
    @Controller
    public String index() {
        return "index.html";
    }
}
