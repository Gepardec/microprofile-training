package com.gepardec.training.microprofile.basic.restclient;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;

@Path("/")
public interface HttpbinClientApi {

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
