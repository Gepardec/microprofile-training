package com.gepardec.training.microprofile.basic.jwt.filter;

import com.gepardec.training.microprofile.HeaderHelper;
import jakarta.ws.rs.WebApplicationException;
import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.container.ContainerRequestFilter;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.Provider;
import org.eclipse.microprofile.jwt.JsonWebToken;

import java.io.IOException;

@Provider
public class JwtFilter implements ContainerRequestFilter {

    @Override
    public void filter(ContainerRequestContext requestContext) throws IOException {
        if (requestContext.getUriInfo().getPath().contains("jwt") && HeaderHelper.isJsHttpClientRequest(requestContext.getHeaders())) {
            try {
                Class.forName(JsonWebToken.class.getName());
            } catch (NoClassDefFoundError | ClassNotFoundException e) {
                throw new WebApplicationException(Response.status(Response.Status.INTERNAL_SERVER_ERROR).entity("MicroProfile JWT not loaded").build());
            }
        }
    }
}
