package com.gepardec.training.microprofile.basic.faulttolerance;

import com.gepardec.training.microprofile.common.faulttolerance.CircuitBreakerCallState;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.mvc.Controller;
import jakarta.mvc.Models;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.QueryParam;
import jakarta.ws.rs.core.Response;

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
