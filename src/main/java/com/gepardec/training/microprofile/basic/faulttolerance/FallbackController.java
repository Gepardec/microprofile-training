package com.gepardec.training.microprofile.basic.faulttolerance;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.mvc.Controller;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

@RequestScoped
@Path(("/basic/faulttolerance/fallback"))
public class FallbackController {

    @Inject
    private FallbackService fallbackService;

    @Controller
    @GET
    @Path("/")
    public String get() {
        return "basic/faulttolerance/fallback.xhtml";
    }

    @POST
    @Path("/fallbacked")
    public Response fallbacked() {
        try {
            return Response.ok(fallbackService.fails()).build();
        } catch (Exception e) {
            return Response.serverError().entity(e.getMessage()).build();
        }
    }
}
