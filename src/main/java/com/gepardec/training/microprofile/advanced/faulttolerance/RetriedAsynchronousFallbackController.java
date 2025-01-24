package com.gepardec.training.microprofile.advanced.faulttolerance;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.mvc.Controller;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

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
