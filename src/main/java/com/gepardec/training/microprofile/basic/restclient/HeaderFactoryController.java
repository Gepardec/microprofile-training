package com.gepardec.training.microprofile.basic.restclient;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.mvc.Controller;
import javax.mvc.Models;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@RequestScoped
@Path(("/basic/restclient/headers-factory"))
public class HeaderFactoryController {

    @Inject
    @RestClient
    private RestClientAPI api;

    @Inject
    private Models model;

    @Controller
    @Path("/")
    @GET
    public String get() {
        model.put("value", api.patch());
        return "basic/restclient/headers-factory.xhtml";
    }
}
