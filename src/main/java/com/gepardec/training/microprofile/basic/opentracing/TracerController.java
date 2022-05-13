package com.gepardec.training.microprofile.basic.opentracing;

import jakarta.enterprise.context.RequestScoped;
import jakarta.mvc.Controller;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import org.eclipse.microprofile.opentracing.Traced;

@Path("/basic/opentracing/tracer")
@RequestScoped
@Controller
@Traced
public class TracerController {

    @Path("/")
    @GET
    public String index() {
        return "basic/opentracing/tracer.xhtml";
    }
}
