package com.gepardec.training.microprofile;

import com.gepardec.training.microprofile.common.faulttolerance.CircuitBreakerCallState;
import org.eclipse.microprofile.faulttolerance.exceptions.CircuitBreakerOpenException;
import org.slf4j.Logger;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Dependent
@Provider
public class CircuitBreakerOpenExceptionMapper implements ExceptionMapper<CircuitBreakerOpenException> {

    @Inject
    private Logger log;

    @Inject
    private CircuitBreakerCallState callState;

    @Override
    public Response toResponse(CircuitBreakerOpenException exception) {
        callState.resetState();
        log.warn("Call failed because circuit has been opened: " + exception.getMessage());
        return Response.status(ApplicationHttpStatusCode.CIRCUIT_OPEN).entity("CircuitBreaker opened endpoint").build();
    }
}
