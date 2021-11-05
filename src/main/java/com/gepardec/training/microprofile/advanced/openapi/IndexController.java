package com.gepardec.training.microprofile.advanced.openapi;

import com.gepardec.training.microprofile.TrainingMetric;
import org.eclipse.microprofile.metrics.annotation.*;

import javax.enterprise.context.RequestScoped;
import javax.mvc.Controller;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

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
