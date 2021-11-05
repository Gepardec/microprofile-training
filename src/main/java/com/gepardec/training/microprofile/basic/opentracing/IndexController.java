package com.gepardec.training.microprofile.basic.opentracing;

import com.gepardec.training.microprofile.TrainingMetric;

import javax.enterprise.context.RequestScoped;
import javax.mvc.Controller;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

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
