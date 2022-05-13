package com.gepardec.training.microprofile.advanced.jwt;

import com.gepardec.training.microprofile.TrainingMetric;
import jakarta.enterprise.context.RequestScoped;
import jakarta.mvc.Controller;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("/advanced/jwt")
@RequestScoped
@Controller
@TrainingMetric
public class IndexController {

    @GET
    @Path("/index")
    public String get() {
        return "advanced/jwt/index.xhtml";
    }
}
