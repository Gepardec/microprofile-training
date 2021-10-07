package com.gepardec.training.microprofile.advanced.restclient;

import com.gepardec.training.microprofile.basic.restclient.RestClientExceptionMapper;
import org.eclipse.microprofile.rest.client.annotation.RegisterProvider;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.concurrent.CompletionStage;

@RegisterProvider(RestClientExceptionMapper.class)
//@RegisterProvider(MyClientRequestFilter.class)
@RegisterProvider(MyFactory.class)
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
