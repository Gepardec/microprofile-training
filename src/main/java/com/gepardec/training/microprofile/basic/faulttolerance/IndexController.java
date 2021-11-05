package com.gepardec.training.microprofile.basic.faulttolerance;

import com.gepardec.training.microprofile.TrainingMetric;
import org.eclipse.microprofile.metrics.annotation.*;

import javax.enterprise.context.RequestScoped;
import javax.mvc.Controller;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/basic/faulttolerance")
@RequestScoped
@Controller
@TrainingMetric
public class IndexController {

    @GET
    @Path("/index")
    public String get() {
        return "basic/faulttolerance/index.xhtml";
    }
}
