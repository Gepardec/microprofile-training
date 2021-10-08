package com.gepardec.training.microprofile.basic.jwt.filter;

import org.eclipse.microprofile.jwt.JsonWebToken;

import javax.ws.rs.WebApplicationException;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;
import java.io.IOException;

@Provider
public class JwtFilter implements ContainerRequestFilter {

    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
        if (requestContext.getUriInfo().getPath().contains("jwt") && requestContext.getHeaders().get("X-HttpClient-Training") != null) {
            try {
                Class.forName(JsonWebToken.class.getName());
            } catch (NoClassDefFoundError | ClassNotFoundException e) {
                throw new WebApplicationException(Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("MicroProfile JWT not loaded").build());
            }
        }
    }
}
