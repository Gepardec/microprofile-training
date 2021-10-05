package com.gepardec.training.microprofile.basic.restclient;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.mvc.Controller;
import javax.mvc.Models;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.net.URISyntaxException;

@RequestScoped
@Path(("/basic/restclient/restClientBuilder"))
public class RestClientBuilderController {

    @Inject
    private Models model;

    @Controller
    @Path("/")
    @GET
    public String builder() throws URISyntaxException {
        UseRestClientBuilder restClientBuilder = new UseRestClientBuilder();
        model.put("value", restClientBuilder.getResponse());
        return "basic/restclient/restClientBuilder.xhtml";

    }
}
