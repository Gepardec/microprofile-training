package com.gepardec.training.microprofile.basic.faulttolerance;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.mvc.Controller;
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

    @Controller
    @GET
    @Path("/")
    public String get() {
        callState.reset();
        return "basic/faulttolerance/circuitbreaker.xhtml";
    }

    @POST
    @Path("/init")
    public Response init(@QueryParam("failEachCount") @NotNull @Min(2) int failEachCount,
            @QueryParam("failAfterEachCount") @NotNull @Min(1) int failAfterEachCount) {
        callState.init(failEachCount, failAfterEachCount);
        return Response.ok().build();
    }

    @POST
    @Path("/circuitbreaked")
    //    @CircuitBreaker(failureRatio = 0.2, requestVolumeThreshold = 10, delay = 2000L, delayUnit = ChronoUnit.MILLIS, successThreshold = 1)
    public Response circuitbreaked() {
        callState.failIfSupposedTo();
        return Response.ok().build();
    }

    @POST
    @Path("/reset")
    public Response reset() {
        callState.reset();
        return Response.ok("Reset the call state").build();
    }
}
