package com.gepardec.training.microprofile;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;
import org.eclipse.microprofile.faulttolerance.exceptions.BulkheadException;
import org.slf4j.Logger;

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
