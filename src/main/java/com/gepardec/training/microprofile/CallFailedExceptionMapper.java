package com.gepardec.training.microprofile;

import org.slf4j.Logger;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Dependent
@Provider
public class CallFailedExceptionMapper implements ExceptionMapper<CallFailedException> {

    @Inject
    private Logger log;

    @Override
    public Response toResponse(CallFailedException exception) {
        log.warn("Call failed intentionally: " + exception.getMessage());
        return Response.status(ApplicationHttpStatusCode.INTENTIONAL_FAIL).entity(exception.getMessage()).build();
    }
}
