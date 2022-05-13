package com.gepardec.training.microprofile.advanced.faulttolerance;

import jakarta.enterprise.context.RequestScoped;
import jakarta.mvc.Controller;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import org.eclipse.microprofile.metrics.annotation.*;

@Path("/advanced/faulttolerance")
@RequestScoped
@Controller
@Counted(name = "counted")
@Metered(name = "metered")
@Timed(name = "timed")
@SimplyTimed(name = "simply-timed")
@ConcurrentGauge(name = "concurrent-gauge")
public class IndexController {

    @GET
    @Path("/index")
    public String get() {
        return "advanced/faulttolerance/index.xhtml";
    }
}
