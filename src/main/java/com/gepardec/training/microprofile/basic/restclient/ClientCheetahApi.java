package com.gepardec.training.microprofile.basic.restclient;

import org.eclipse.microprofile.rest.client.annotation.RegisterClientHeaders;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


//Not given
//@RegisterProviders({
//        @RegisterProvider(RestClientExceptionMapper.class),
//})
//@RegisterClientHeaders(RestClientHeaderHandler.class)
//Not given
// Can also be configured via MP-config
@RegisterRestClient//(baseUri = "http://localhost:8080/mptraining/api/")
//For the first exercise base uri is not given
@Path("/cheetahs")
public interface ClientCheetahApi {

    @GET
    @Produces(MediaType.TEXT_HTML)
    String welcomeMessage();

    @GET
    @Path("/{name}")
    @Produces(MediaType.TEXT_HTML)
    String greetCheetah(@PathParam("name") String name);

    @Path("/invalid")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    Response invalid();
}
