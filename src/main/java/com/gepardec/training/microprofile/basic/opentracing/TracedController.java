package com.gepardec.training.microprofile.basic.opentracing;

import org.eclipse.microprofile.opentracing.Traced;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.mvc.Controller;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

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
        tracedService.auoTraced();
        tracedService.invoke();
        return "basic/opentracing/traced.xhtml";
    }
}
