package com.gepardec.training.microprofile.basic.restclient;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@RequestScoped
public class RestClientCdi {

    @Inject
    @RestClient
    RestClientAPI api;


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getResponse() {
        if (api != null) {
            return api.get();
        }
        return null;
    }
}
