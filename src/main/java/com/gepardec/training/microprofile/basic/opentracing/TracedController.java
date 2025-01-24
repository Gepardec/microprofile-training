package com.gepardec.training.microprofile.basic.opentracing;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.mvc.Controller;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("/basic/opentracing/traced")
@RequestScoped
@Controller
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
