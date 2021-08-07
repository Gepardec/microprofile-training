package com.gepardec.training.microprofile.basic.faulttolerance;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.mvc.Controller;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

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
        // TODO: Go to 'TimeoutService#timedout' and make this method call fail after one second via @Timeout.
        try {
            timeoutService.timedout();
            return Response.serverError().entity("Call didn't time out").build();
        } catch (Exception e) {
            return Response.ok(e.getMessage()).build();
        }
    }
}
