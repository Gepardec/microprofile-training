package com.gepardec.training.microprofile.advanced.faulttolerance;

import com.gepardec.training.microprofile.common.faulttolerance.CircuitBreakerCallState;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.mvc.Controller;
import javax.mvc.Models;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@RequestScoped
@Path("/advanced/faulttolerance/bulkhead-circuitbreaker-fallback")
public class BulkheadCircuitBreakerFallbackController {

    private static final int successfulRequests = 2;

    private static final int failCount = 2;

    private static final int parallelCount = 6;

    @Inject
    private CircuitBreakerCallState callState;

    @Inject
    private Models models;

    @Controller
    @GET
    @Path("/")
    public String get() {
        reset();
        return "advanced/faulttolerance/bulkhead-circuitbreaker-fallback.xhtml";
    }

    @POST
    @Path("/invoke")
    @Produces(MediaType.TEXT_PLAIN)
    public Response invoke() {
        try {
            Thread.sleep(250);
            callState.failIfSupposedTo();
            return Response.ok().build();
        } catch (InterruptedException e) {
            return Response.serverError().entity(e.getMessage()).build();
        }
    }

    @POST
    @Path("/reset")
    @Produces(MediaType.TEXT_PLAIN)
    public Response reset() {
        callState.resetState();
        callState.resetConfiguration();
        callState.init(successfulRequests, failCount);
        models.put("parallelCount", parallelCount);
        models.put("successfulCount", callState.getFailEachCount());
        models.put("failingCount", callState.getFailAfterEachCount());

        return Response.ok().build();
    }
}
