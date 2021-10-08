package com.gepardec.training.microprofile.basic.restclient;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.mvc.Controller;
import javax.mvc.Models;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@RequestScoped
@Path(("/basic/restclient/cdi"))
public class CdiController {

    @Inject
    private Models model;

    @Inject
    private RestClientCdi restClientCdi;

    @Controller
    @Path("/")
    @GET
    public String cdi() {
        model.put("value", restClientCdi.getResponse());
        return "basic/restclient/cdi.xhtml";
    }
}
