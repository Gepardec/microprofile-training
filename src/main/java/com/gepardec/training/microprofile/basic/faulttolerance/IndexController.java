package com.gepardec.training.microprofile.basic.faulttolerance;

import javax.enterprise.context.RequestScoped;
import javax.mvc.Controller;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

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
