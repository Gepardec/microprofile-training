package com.gepardec.training.microprofile.basic.jwt;

import com.gepardec.training.microprofile.TrainingMetric;
import jakarta.enterprise.context.RequestScoped;
import jakarta.mvc.Controller;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import org.eclipse.microprofile.opentracing.Traced;

@Path("/basic/jwt")
@RequestScoped
@Controller
@TrainingMetric
@Traced
public class IndexController {

    @GET
    @Path("/index")
    public String get() {
        return "basic/jwt/index.xhtml";
    }
}
