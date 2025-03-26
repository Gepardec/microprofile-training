package com.gepardec.training.microprofile;

import jakarta.inject.Inject;
import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.container.ContainerRequestFilter;
import jakarta.ws.rs.ext.Provider;
import org.slf4j.Logger;

import java.io.IOException;

@Provider
public class LoggingFilter implements ContainerRequestFilter {

    @Inject Logger logger;

    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
        logger.info("Request received: " + requestContext.getUriInfo().getRequestUri());
    }
}
