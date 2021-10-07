package com.gepardec.training.microprofile.basic.restclient;

import org.eclipse.microprofile.rest.client.annotation.RegisterClientHeaders;
import org.eclipse.microprofile.rest.client.annotation.RegisterProvider;
import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;

@RegisterClientHeaders(RestClientHeaderHandler.class)
@RegisterProvider(RestClientExceptionMapper.class)
// @RegisterProvider(ResponseFilter.class)
@RegisterRestClient(configKey = "user-api")
@Path("/")
public interface RestClientAPI {


    @Path("/get")
    @Produces(MediaType.APPLICATION_JSON)
    @GET
    String get();

    @Path("/users")
    @Produces(MediaType.APPLICATION_JSON)
    @GET
    String getUsers();

    @Path("/delete")
    @DELETE
    @Produces(MediaType.APPLICATION_JSON)
    String delete();

    @Path("/patch")
    @PATCH
    @Produces(MediaType.APPLICATION_JSON)
    String patch();

    @Path("/post")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    String post();

    @Path("/status/500")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    String invalid();
}
