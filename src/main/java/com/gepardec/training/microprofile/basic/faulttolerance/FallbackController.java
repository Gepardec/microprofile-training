package com.gepardec.training.microprofile.basic.faulttolerance;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.mvc.Controller;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

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
