package com.gepardec.training.microprofile.basic.restclient;

import com.gepardec.training.microprofile.basic.restservice.ClientCheetahApi;

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

    public Object callCheetahService() throws URISyntaxException {
        createRestClientBuilder();
        if (cheetahApi != null) {
            return cheetahApi.welcomeMessage();
        }
        return null;
    }
}
