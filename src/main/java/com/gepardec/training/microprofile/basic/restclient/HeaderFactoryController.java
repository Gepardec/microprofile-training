package com.gepardec.training.microprofile.basic.restclient;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.mvc.Controller;
import javax.mvc.Models;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/basic/restclient/headers-factory")
@RequestScoped
@Controller
public class HeaderFactoryController {

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
