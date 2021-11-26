package com.gepardec.training.microprofile.basic.health;

import com.gepardec.training.microprofile.TrainingMetric;
import org.eclipse.microprofile.opentracing.Traced;

import javax.enterprise.context.RequestScoped;
import javax.mvc.Controller;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/basic/health")
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
        return "basic/health/index.xhtml";
    }

}
