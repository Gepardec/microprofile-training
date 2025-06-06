package com.gepardec.training.microprofile.basic.restclient;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.mvc.Controller;
import jakarta.mvc.Models;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import org.eclipse.microprofile.rest.client.inject.RestClient;

@Path("/basic/restclient/headers-factory")
@RequestScoped
@Controller
public class HeaderFactoryController {

    @Inject
    @RestClient
    private HttpbinClientApi api;

    @Inject
    private Models model;

    @Path("/")
    @GET
    public String get() {
        String value = "HttpbinClientApi is not ready yet. Is it already a valid CDI bean and correctly injected?";
        if (api != null) {
            value = api.patch();
        }
        model.put("value", value);
        return "basic/restclient/headers-factory.xhtml";
    }
}
