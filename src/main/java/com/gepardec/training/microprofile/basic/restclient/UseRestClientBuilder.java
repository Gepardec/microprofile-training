package com.gepardec.training.microprofile.basic.restclient;

import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.net.URI;
import java.net.URISyntaxException;

public class UseRestClientBuilder {

    private ClientCheetahApi cheetahApi;


    private void createRestClientBuilder() throws URISyntaxException {

        //URI is already given
        URI apiUri = new URI("http://localhost:8080/mptraining/api/");
        //Not given
//        cheetahApi = RestClientBuilder.newBuilder()
//                .baseUri(apiUri)
//                .build(ClientCheetahApi.class);

    }


    @GET
    @Produces(MediaType.TEXT_HTML)
    public String welcomeMessage() throws URISyntaxException {
        createRestClientBuilder();
        if (cheetahApi != null) {
            return cheetahApi.welcomeMessage();
        }
        return null;
    }
}
