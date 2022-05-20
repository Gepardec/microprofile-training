package com.gepardec.training.microprofile.basic.faulttolerance;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.mvc.Controller;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@RequestScoped
@Path(("/basic/faulttolerance/timeout"))
public class TimeoutController {

    @Inject
    private TimeoutService timeoutService;

    @Controller
    @GET
    @Path("/")
    public String get() {
        return "basic/faulttolerance/timeout.xhtml";
    }

    @POST
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/timedout")
    public Response timedout() {
        try {
            timeoutService.fails();
            return Response.serverError().entity("Call didn't time out").build();
        } catch (Exception e) {
            return Response.ok(e.getMessage()).build();
        }
    }
}
