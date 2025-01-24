package com.gepardec.training.microprofile.advanced.faulttolerance;

import org.eclipse.microprofile.metrics.annotation.*;

import jakarta.enterprise.context.RequestScoped;
import jakarta.mvc.Controller;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("/advanced/faulttolerance")
@RequestScoped
@Controller
@Counted(name = "counted")
//TODO: fix @Metered(name = "metered")
@Timed(name = "timed")
//TODO: fix @SimplyTimed(name = "simply-timed")
//TODO: fix @ConcurrentGauge(name = "concurrent-gauge")
public class IndexController {

    @GET
    @Path("/index")
    public String get() {
        return "advanced/faulttolerance/index.xhtml";
    }
}
