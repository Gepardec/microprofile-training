package com.gepardec.training.microprofile.basic.restservice;

import org.eclipse.microprofile.rest.client.inject.RegisterRestClient;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;


//Not given
// Can also be configured via MP-config
@RegisterRestClient//(baseUri = "http://localhost:8080/mptraining/api/")
@Path("/cheetahs")
public interface ClientCheetahApi {
    @GET
    @Path("/{name}")
    @Produces(MediaType.TEXT_HTML)
    String greetCheetah(@PathParam("name") String name);

    @GET
    @Produces(MediaType.TEXT_HTML)
    String welcomeMessage();
}
