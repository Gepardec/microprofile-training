package com.gepardec.training.microprofile;

import org.eclipse.microprofile.faulttolerance.exceptions.BulkheadException;

import javax.enterprise.context.Dependent;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.ExceptionMapper;
import javax.ws.rs.ext.Provider;

@Dependent
@Provider
public class BulkheadExceptionMapper implements ExceptionMapper<BulkheadException> {

    @Override
    public Response toResponse(BulkheadException exception) {
        return Response.serverError().entity("Bulkhead rejected call").build();
    }
}
