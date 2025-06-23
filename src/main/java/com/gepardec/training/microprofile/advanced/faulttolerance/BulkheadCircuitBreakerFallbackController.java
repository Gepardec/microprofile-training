package com.gepardec.training.microprofile.advanced.faulttolerance;

import com.gepardec.training.microprofile.ApplicationHttpStatusCode;
import com.gepardec.training.microprofile.common.faulttolerance.CircuitBreakerCallState;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.mvc.Controller;
import jakarta.mvc.Models;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.faulttolerance.*;
import org.eclipse.microprofile.faulttolerance.exceptions.BulkheadException;
import org.eclipse.microprofile.faulttolerance.exceptions.CircuitBreakerOpenException;

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

    static class ResponseFallbackHandler implements FallbackHandler<Response> {

        @Override
        public Response handle(ExecutionContext context) {
            if (context.getFailure() instanceof CircuitBreakerOpenException) {
                return Response.status(ApplicationHttpStatusCode.TOO_MANY_FAILURES_TRY_AGAIN_LATER).build();
            } else if (context.getFailure() instanceof BulkheadException) {
                return Response.status(ApplicationHttpStatusCode.TOO_MANY_REQUESTS).build();
            } else {
                return Response.status(Response.Status.SERVICE_UNAVAILABLE).build();
            }
        }
    }

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
    @Bulkhead(4)
    @CircuitBreaker
    @Fallback(ResponseFallbackHandler.class)
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
