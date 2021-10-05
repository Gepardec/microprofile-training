package com.gepardec.training.microprofile.basic.restclient;

import org.eclipse.microprofile.rest.client.RestClientBuilder;

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
        //Not given
        api = RestClientBuilder.newBuilder()
                .baseUri(apiUri)
                .build(RestClientAPI.class);
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
