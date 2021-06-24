package com.gepardec.training.microprofile.basic.restclient;

import com.gepardec.training.microprofile.basic.restservice.ClientCheetahApi;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

@RequestScoped
public class RestClientCdi {
    @Inject
    ClientCheetahApi cheetahApi;


    public Object callCheetahService() {
        return cheetahApi.welcomeMessage();
    }
}
