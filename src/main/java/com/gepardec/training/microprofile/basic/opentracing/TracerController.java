package com.gepardec.training.microprofile.basic.opentracing;

import org.eclipse.microprofile.opentracing.Traced;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.mvc.Controller;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/basic/opentracing")
@RequestScoped
@Controller
@Traced
public class TracerController {

    @Inject
    private TracerService tracerService;

    @Path("/")
    @GET
    public String get() {
        return index();
    }

    @Path("/tracer")
    @GET
    public String index() {
        tracerService.auoTraced();
        tracerService.customTraced();
        return "basic/opentracing/tracer.xhtml";
    }
}
