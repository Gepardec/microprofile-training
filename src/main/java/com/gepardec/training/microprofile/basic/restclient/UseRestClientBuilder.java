package com.gepardec.training.microprofile.basic.restclient;

import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.net.URI;
import java.net.URISyntaxException;

public class UseRestClientBuilder {

    private RestClientAPI api;


    private void createRestClientBuilder() throws URISyntaxException {

        //URI is already given
        URI apiUri = new URI("http://httpbin.org/");
        // initialize api with RestClientBuilder
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public String getResponse() throws URISyntaxException {
        createRestClientBuilder();
        if (api != null) {
            return api.get();
        }
        return null;
    }
}
