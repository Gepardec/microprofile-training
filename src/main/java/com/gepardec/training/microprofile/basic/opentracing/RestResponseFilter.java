package com.gepardec.training.microprofile.basic.opentracing;

import io.opentracing.Span;
import io.opentracing.Tracer;

import javax.annotation.Priority;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.Priorities;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.ext.Provider;
import java.io.IOException;

@Provider
@Priority(Priorities.USER + 1)
@ApplicationScoped
public class RestResponseFilter implements ContainerResponseFilter {

    @Inject
    private Tracer tracer;

    @Override
    public void filter(ContainerRequestContext requestContext, ContainerResponseContext responseContext) throws IOException {
    }
}
