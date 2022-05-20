package com.gepardec.training.microprofile.basic.config;

import com.gepardec.training.microprofile.TrainingMetric;
import jakarta.enterprise.context.RequestScoped;
import jakarta.mvc.Controller;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import org.eclipse.microprofile.opentracing.Traced;

@Path("/basic/config")
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
        return "basic/config/index.xhtml";
    }

}
