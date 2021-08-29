package com.gepardec.training.microprofile.advanced.faulttolerance;

import javax.enterprise.context.RequestScoped;
import javax.mvc.Controller;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

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
