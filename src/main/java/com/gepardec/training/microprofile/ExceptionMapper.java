package com.gepardec.training.microprofile;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.eclipse.krazo.engine.Viewable;
import org.slf4j.Logger;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import jakarta.mvc.Models;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.core.Context;
import jakarta.ws.rs.core.HttpHeaders;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.core.UriInfo;
import jakarta.ws.rs.ext.Provider;

/**
 * This class handles the errors by extracting the error information and returning the error page
 */
@Dependent
@Provider
public class ExceptionMapper implements jakarta.ws.rs.ext.ExceptionMapper<Throwable> {

    @Context
    private UriInfo uriInfo;

    @Context
    private HttpHeaders httpHeaders;

    @Inject
    private Logger log;

    @Inject
    private Models models;

    @Override
    public Response toResponse(Throwable exception) {
        if (exception instanceof WebApplicationException && HeaderHelper.isJsHttpClientRequest(httpHeaders.getRequestHeaders())) {
            return ((WebApplicationException) exception).getResponse();
        } else {
            final Viewable view = new Viewable("error.xhtml");

            models.put("exceptionType", exception.getClass().getName());
            models.put("exceptionMessage", exception.getMessage());
            models.put("uri", uriInfo.getAbsolutePath().toString());
            models.put("stackTrace", ExceptionUtils.getStackTrace(exception));
            log.error("Error occurred on '" + uriInfo.getAbsolutePath() + "'", exception);

            return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(view).build();
        }
    }
}
