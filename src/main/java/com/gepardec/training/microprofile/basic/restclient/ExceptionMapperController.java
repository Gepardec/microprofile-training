package com.gepardec.training.microprofile.basic.restclient;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.mvc.Controller;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@RequestScoped
@Path("/basic/restclient/exception-mapper")
public class ExceptionMapperController {

    @Inject
    @RestClient
    private RestClientAPI api;

    @Controller
    @Path("/")
    @GET
    public String get() {
        return "basic/restclient/exception-mapper.xhtml";
    }

    @Path("/error")
    @GET
    public String createError() {
        return api.invalid();
    }

}
