package com.gepardec.training.microprofile.basic.opentracing;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.mvc.Controller;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import org.eclipse.microprofile.opentracing.Traced;

@Path("/basic/opentracing/traced")
@RequestScoped
@Controller
@Traced
public class TracedController {

    @Inject
    private TracedService tracedService;

    @Path("/")
    @GET
    public String index() {
        // Call the methods to trace here
        return "basic/opentracing/traced.xhtml";
    }
}
