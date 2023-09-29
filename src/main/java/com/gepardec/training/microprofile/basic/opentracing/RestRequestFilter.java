package com.gepardec.training.microprofile.basic.opentracing;

import io.opentracing.Span;
import io.opentracing.Tracer;

import javax.annotation.Priority;
import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.Priorities;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.ext.Provider;
import java.io.IOException;

@Provider
@Priority(Priorities.USER + 1)
@ApplicationScoped
public class RestRequestFilter implements ContainerRequestFilter {

    @Inject
    private Tracer tracer;

    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
        Span span = tracer.activeSpan();
        span.setTag("http-uri", requestContext.getUriInfo().getRequestUri().toString());
        span.setTag("http-method", requestContext.getMethod());
        requestContext.getHeaders().forEach((key, value) ->
                span.setTag("http-header-" + key, String.join(", ", value)));
    }
}
