package com.gepardec.training.microprofile.advanced.faulttolerance;

import jakarta.enterprise.context.RequestScoped;
import jakarta.mvc.Controller;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("/advanced/faulttolerance")
@RequestScoped
@Controller
public class IndexController {

    @GET
    @Path("/index")
    public String get() {
        return "advanced/faulttolerance/index.xhtml";
    }
}
