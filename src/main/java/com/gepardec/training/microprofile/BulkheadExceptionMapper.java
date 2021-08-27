package com.gepardec.training.microprofile;

import org.eclipse.microprofile.faulttolerance.exceptions.BulkheadException;
import org.slf4j.Logger;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Dependent
@Provider
public class BulkheadExceptionMapper implements ExceptionMapper<BulkheadException> {

    @Inject
    private Logger log;

    @Override
    public Response toResponse(BulkheadException exception) {
        log.warn("Call failed because bulkhead rejected call: " + exception.getMessage());
        return Response.status(ApplicationHttpStatusCode.BULKHEAD_REJECT).entity("Bulkhead rejected call").build();
    }
}
