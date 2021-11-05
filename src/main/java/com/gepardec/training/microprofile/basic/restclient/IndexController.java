package com.gepardec.training.microprofile.basic.restclient;

import com.gepardec.training.microprofile.TrainingMetric;
import org.eclipse.microprofile.metrics.annotation.*;

import javax.enterprise.context.RequestScoped;
import javax.mvc.Controller;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/basic/restclient")
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
        return "basic/restclient/index.xhtml";
    }

}
