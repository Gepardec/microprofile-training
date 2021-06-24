package com.gepardec.training.microprofile.basic.restservice;

import javax.enterprise.context.RequestScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/cheetahs")
@RequestScoped
public class CheetahApiImpl implements CheetahApi {

    @Override
    @GET
    @Path("/{name}")
    @Produces(MediaType.TEXT_HTML)
    public String greetCheetah(@PathParam("name") String name) {
        return String.format("Hello cheetah %s!", name);
    }

    @GET
    @Produces(MediaType.TEXT_HTML)
    public String welcomeMessage() {
        return "Hello cheetahs";
    }
}
