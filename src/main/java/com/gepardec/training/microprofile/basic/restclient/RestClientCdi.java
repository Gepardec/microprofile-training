package com.gepardec.training.microprofile.basic.restclient;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@RequestScoped
public class RestClientCdi {
    @Inject
    @RestClient
    ClientCheetahApi cheetahApi;


    @GET
    @Produces(MediaType.TEXT_HTML)
    public String welcomeMessage() {
        return cheetahApi.welcomeMessage();
    }

    @GET
    @Path("/{name}")
    @Produces(MediaType.TEXT_HTML)
    public String greetCheetah(@PathParam("name") String name){
        return cheetahApi.greetCheetah(name);
    }

    @Path("/invalid")
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response invalid(){
        return cheetahApi.invalid();
    }
}
