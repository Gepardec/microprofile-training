package com.gepardec.training.microprofile.basic;

import com.gepardec.training.microprofile.TrainingMetric;
import org.eclipse.microprofile.opentracing.Traced;

import javax.enterprise.context.RequestScoped;
import javax.mvc.Controller;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/basic")
@RequestScoped
@Controller
@TrainingMetric
@Traced
public class IndexController {

    @Path("/")
    @GET
    public String get() {
        return index();
    }

    @Path("/index")
    @GET
    public String index() {
        return "basic/index.xhtml";
    }
}
