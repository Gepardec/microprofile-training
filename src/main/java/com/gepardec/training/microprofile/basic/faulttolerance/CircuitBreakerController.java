package com.gepardec.training.microprofile.basic.faulttolerance;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.mvc.Controller;
import javax.mvc.Models;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

@Path("/basic/faulttolerance/circuitbreaker")
@RequestScoped
public class CircuitBreakerController {

    @Inject
    private CircuitBreakerCallState callState;

    @Inject
    private Models models;

    @Controller
    @GET
    @Path("/")
    public String get() {
        callState.resetState();
        callState.resetConfiguration();
        models.put("failEachCount", callState.getFailEachCount());
        models.put("failAfterEachCount", callState.getFailAfterEachCount());
        return "basic/faulttolerance/circuitbreaker.xhtml";
    }

    /**
     * Initializes the call state for the example, so we can simulate errors as intended
     *
     * @param failEachCount      successful request before failing
     * @param failAfterEachCount failing request after the successful request
     * @return the response
     */
    @POST
    @Path("/init")
    public Response init(@QueryParam("failEachCount") @NotNull @Min(2) int failEachCount,
            @QueryParam("failAfterEachCount") @NotNull @Min(1) int failAfterEachCount) {
        callState.init(failEachCount, failAfterEachCount);
        return Response.ok().build();
    }

    @POST
    @Path("/circuitbreaked")
    public Response circuitbreaked() {
        callState.failIfSupposedTo();
        return Response.ok().build();
    }

    /**
     * Resets the call state to it's initial values by keeping the client provided settings.
     *
     * @return the response
     */
    @POST
    @Path("/reset")
    public Response reset() {
        callState.resetState();
        return Response.ok("Reset the call state").build();
    }
}
