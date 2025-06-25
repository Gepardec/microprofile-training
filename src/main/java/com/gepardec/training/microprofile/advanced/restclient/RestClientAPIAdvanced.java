package com.gepardec.training.microprofile.advanced.restclient;

import com.gepardec.training.microprofile.basic.restclient.RestClientExceptionMapper;
import org.eclipse.microprofile.rest.client.annotation.RegisterProvider;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;

import java.util.concurrent.CompletionStage;

@RegisterProvider(RestClientExceptionMapper.class)
@RegisterProvider(AsyncClientRequestFilter.class)
@RegisterProvider(RestAsyncInvocationInterceptorFactory.class)
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
    CompletionStage<String> getAsync();

    @Path("/delay/3")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    CompletionStage<String> postAsync();

}
