package com.gepardec.training.microprofile.basic.opentracing;

/*import io.opentracing.Tracer;*/

import jakarta.annotation.Priority;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.ws.rs.Priorities;
import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.container.ContainerRequestFilter;
import jakarta.ws.rs.ext.Provider;
import java.io.IOException;

@Provider
@Priority(Priorities.USER + 1)
@ApplicationScoped
public class RestRequestFilter implements ContainerRequestFilter {

    /*@Inject
    private Tracer tracer;*/

    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
    }
}
