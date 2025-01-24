package com.gepardec.training.microprofile.advanced.openapi;

import com.gepardec.training.microprofile.TrainingMetric;

import jakarta.enterprise.context.RequestScoped;
import jakarta.mvc.Controller;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("/advanced/openapi")
@RequestScoped
@Controller
@TrainingMetric
public class IndexController {

    @Path("/")
    @GET
    public String get() {
        return index();
    }

    @Path("/index")
    @GET
    public String index() {
        return "advanced/openapi/index.xhtml";
    }

}
