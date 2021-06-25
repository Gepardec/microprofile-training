package com.gepardec.training.microprofile.basic.restservice;

import javax.enterprise.context.RequestScoped;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/cheetahs")
@RequestScoped
public class CheetahApiImpl implements CheetahApi {

    @GET
    @Produces(MediaType.TEXT_HTML)
    public String welcomeMessage() {
        return "Hello cheetahs";
    }

    @Override
    @GET
    @Path("/{name}")
    @Produces(MediaType.TEXT_HTML)
    public String greetCheetah(@PathParam("name") String name) {
        return String.format("Hello cheetah %s!", name);
    }

    @Path("/invalid")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response invalid() {
            return Response
                    .status(Response.Status.BAD_REQUEST)
                    .entity("This is a planned error")
                    .build();
    }
}
