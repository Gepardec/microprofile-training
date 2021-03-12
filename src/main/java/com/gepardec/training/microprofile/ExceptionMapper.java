package com.gepardec.training.microprofile;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.lang3.exception.ExceptionUtils;
import org.eclipse.krazo.engine.Viewable;
import org.slf4j.Logger;

import javax.inject.Inject;
import javax.mvc.Models;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriInfo;
import javax.ws.rs.ext.Provider;

@Provider
public class ExceptionMapper implements javax.ws.rs.ext.ExceptionMapper<Throwable> {

    @Context
    private UriInfo uriInfo;

    @Inject
    private Models model;

    @Inject
    private HttpServletRequest request;

    @Inject
    private Logger log;

    @Override
    public Response toResponse(Throwable exception) {
        final Viewable view = new Viewable("error.html");
        final Response.Status status = Response.Status.INTERNAL_SERVER_ERROR;
        final String backURI = request.getContextPath() + ((uriInfo.getPath().contains("/uc")) ? "/uc/index" : "/index");

        model.put("request", request);
        model.put("backURI", backURI);
        model.put("status", status.getStatusCode() + " (" + status.toString() + ")");
        model.put("path", uriInfo.getAbsolutePath());
        model.put("exceptionName", exception.getClass().getName());
        model.put("exceptionMessage", StringUtils.defaultString(exception.getMessage(), " - "));
        model.put("stackTrace", ExceptionUtils.getStackTrace(exception));

        log.error("Error occurred on '" + uriInfo.getAbsolutePath() + "'", exception);

        return Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity(view).build();
    }
}
