package com.gepardec.training.microprofile.basic.restclient;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.mvc.Controller;
import javax.mvc.Models;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@RequestScoped
@Path(("/basic/restclient/headersFactory"))
public class ClientHeaderController {

    @Inject
    private Models model;

    @Inject
    @RestClient
    RestClientAPI api;

    @Controller
    @Path("/")
    @GET
    public String get() {
        model.put("value", api.patch());
        return "basic/restclient/headersFactory.xhtml";
    }
}
