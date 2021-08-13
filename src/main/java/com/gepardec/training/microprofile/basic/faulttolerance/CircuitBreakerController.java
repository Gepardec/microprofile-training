package com.gepardec.training.microprofile.basic.faulttolerance;

import org.eclipse.microprofile.faulttolerance.CircuitBreaker;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.mvc.Controller;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
import java.time.temporal.ChronoUnit;

@Path("/basic/faulttolerance/circuitbreaker")
@RequestScoped
public class CircuitBreakerController {

    @Inject
    CircuitBreakerCallState callState;

    @Controller
    @GET
    @Path("/")
    public String get() {
        return "basic/faulttolerance/circuitbreaker.xhtml";
    }

    @POST
    @Path("/circuitbreaked")
    @CircuitBreaker(failureRatio = 0.2, requestVolumeThreshold = 10, delay = 2000L, delayUnit = ChronoUnit.MILLIS, successThreshold = 1)
    public Response circuitbreaked() {
        callState.failIfSupposedTo();
        return Response.ok().build();
    }

    @POST
    @Path("/stop")
    public Response stop() {
        callState.reset();
        return Response.ok().build();
    }
}
