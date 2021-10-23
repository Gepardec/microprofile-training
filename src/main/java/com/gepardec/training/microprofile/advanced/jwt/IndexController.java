package com.gepardec.training.microprofile.advanced.jwt;

import javax.enterprise.context.RequestScoped;
import javax.mvc.Controller;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/advanced/jwt")
@RequestScoped
@Controller
public class IndexController {

    @GET
    @Path("/index")
    public String get() {
        return "advanced/jwt/index.xhtml";
    }
}
