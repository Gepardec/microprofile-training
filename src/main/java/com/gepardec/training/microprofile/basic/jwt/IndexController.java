package com.gepardec.training.microprofile.basic.jwt;

import com.gepardec.training.microprofile.TrainingMetric;
import org.eclipse.microprofile.metrics.annotation.*;

import javax.enterprise.context.RequestScoped;
import javax.mvc.Controller;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/basic/jwt")
@RequestScoped
@Controller
@TrainingMetric
public class IndexController {

    @GET
    @Path("/index")
    public String get() {
        return "basic/jwt/index.xhtml";
    }
}
