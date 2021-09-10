package com.gepardec.training.microprofile.advanced.faulttolerance;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.mvc.Controller;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@RequestScoped
@Path("/advanced/faulttolerance/retried-asynchronous-fallback")
public class RetriedAsynchronousFallbackController {

    @Inject
    private RetriedAsynchronousFallbackService service;

    @Controller
    @GET
    @Path("/")
    public String get() {
        return "advanced/faulttolerance/retried-asynchronous-fallback.xhtml";
    }

    @POST
    @Path("/invoke")
    public Response invoke() {
        try {
            return Response.ok(service.invoke().get()).build();
        } catch (Exception e) {
            return Response.serverError().entity(e.getMessage()).build();
        }
    }
}
