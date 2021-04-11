package com.gepardec.training.microprofile;

import org.eclipse.krazo.engine.Viewable;
import org.slf4j.Logger;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.ext.Provider;

/**
 * This class handles the errors by extracting the error information and returning the error page
 */
@Dependent
@Provider
public class ExceptionMapper implements javax.ws.rs.ext.ExceptionMapper<Throwable> {

    @Context
    private UriInfo uriInfo;

    @Inject
    private Logger log;

    @Override
    public Response toResponse(Throwable exception) {
        final Viewable view = new Viewable("error.xhtml");

        log.error("Error occurred on '" + uriInfo.getAbsolutePath() + "'", exception);

        return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(view).build();
    }
}
