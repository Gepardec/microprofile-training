package com.gepardec.training.microprofile.advanced.config;

import org.eclipse.microprofile.metrics.annotation.*;

import javax.enterprise.context.RequestScoped;
import javax.mvc.Controller;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/advanced/config")
@RequestScoped
@Controller
@Counted(name = "counted")
@Metered(name = "metered")
@Timed(name = "timed")
@SimplyTimed(name = "simply-timed")
@ConcurrentGauge(name = "concurrent-gauge")
public class IndexController {

    @Path("/")
    @GET
    public String get() {
        return index();
    }

    @Path("/index")
    @GET
    public String index() {
        return "advanced/config/index.xhtml";
    }

}
