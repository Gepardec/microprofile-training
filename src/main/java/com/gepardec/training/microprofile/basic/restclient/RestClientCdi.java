package com.gepardec.training.microprofile.basic.restclient;

import javax.enterprise.context.RequestScoped;
import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@RequestScoped
public class RestClientCdi {

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
