package com.gepardec.training.microprofile.basic.metrics;

import org.eclipse.microprofile.metrics.annotation.Counted;
import org.eclipse.microprofile.metrics.annotation.Metered;
import org.eclipse.microprofile.metrics.annotation.SimplyTimed;
import org.eclipse.microprofile.metrics.annotation.Timed;

import javax.enterprise.context.RequestScoped;
import javax.mvc.Controller;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/basic/metrics")
@RequestScoped
@Controller
@Counted(name = "counted")
@Metered(name = "metered")
@Timed(name = "timed")
@SimplyTimed(name = "simply-timed")
public class IndexController {

    @Path("/")
    @GET
    public String get() {
        return index();
    }

    @Path("/index")
    @GET
    public String index() {
        return "basic/metrics/index.xhtml";
    }

}
