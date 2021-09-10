package com.gepardec.training.microprofile;

import org.slf4j.Logger;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

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
