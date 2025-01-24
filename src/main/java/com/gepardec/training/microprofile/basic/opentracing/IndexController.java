package com.gepardec.training.microprofile.basic.opentracing;

import com.gepardec.training.microprofile.TrainingMetric;

import jakarta.enterprise.context.RequestScoped;
import jakarta.mvc.Controller;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("/basic/opentracing")
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
        return "basic/opentracing/index.xhtml";
    }
}
