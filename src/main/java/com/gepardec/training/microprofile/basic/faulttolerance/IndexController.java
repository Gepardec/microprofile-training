package com.gepardec.training.microprofile.basic.faulttolerance;

import jakarta.enterprise.context.RequestScoped;
import jakarta.mvc.Controller;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("/basic/faulttolerance")
@RequestScoped
@Controller
public class IndexController {

    @GET
    @Path("/index")
    public String get() {
        return "basic/faulttolerance/index.xhtml";
    }
}
