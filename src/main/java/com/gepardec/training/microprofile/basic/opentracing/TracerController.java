package com.gepardec.training.microprofile.basic.opentracing;

import org.eclipse.microprofile.opentracing.Traced;

import javax.enterprise.context.RequestScoped;
import javax.mvc.Controller;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

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
