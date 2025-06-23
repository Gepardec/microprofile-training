package com.gepardec.training.microprofile.advanced.restclient;

import com.gepardec.training.microprofile.basic.restclient.RestClientExceptionMapper;
import org.eclipse.microprofile.rest.client.annotation.RegisterProvider;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

@RegisterProvider(RestClientExceptionMapper.class)
@RegisterRestClient(configKey = "user-api")
@Path("/")
public interface RestClientAPIAdvanced {

    @Path("/delay/2")
    @Produces(MediaType.APPLICATION_JSON)
    @GET
    String get();

    @Path("/delay/2")
    @Produces(MediaType.APPLICATION_JSON)
    @GET
    String getAsync();

    @Path("/delay/3")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    String postAsync();

}
