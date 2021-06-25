package com.gepardec.training.microprofile.basic.restservice;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/cheetahs")
public interface CheetahApi {

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
