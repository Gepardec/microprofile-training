package com.gepardec.training.microprofile.basic.restservice;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/cheetahs")
public interface CheetahApi {
    @GET
    @Path("/{name}")
    @Produces(MediaType.TEXT_HTML)
    String greetCheetah(@PathParam("name") String name);

    @GET
    @Produces(MediaType.TEXT_HTML)
    String welcomeMessage();
}
