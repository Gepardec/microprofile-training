package com.gepardec.training.microprofile.basic.faulttolerance;

import org.eclipse.microprofile.metrics.annotation.*;

import javax.enterprise.context.RequestScoped;
import javax.mvc.Controller;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/basic/faulttolerance")
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
        return "basic/faulttolerance/index.xhtml";
    }
}
