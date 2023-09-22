package com.gepardec.training.microprofile.basic.restclient;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.mvc.Controller;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.WebApplicationException;

@Path("/basic/restclient/exception-mapper")
@RequestScoped
public class ExceptionMapperController {

    @Inject
    @RestClient
    private HttpbinClientApi api;

    @Controller
    @Path("/")
    @GET
    public String get() {
        return "basic/restclient/exception-mapper.xhtml";
    }

    @Path("/error")
    @GET
    public String createError() {
        if (api != null) {
            return api.invalid();
        }
        throw new WebApplicationException("HttpbinClientApi is not ready yet. Is it already a valid CDI bean and correctly injected?");
    }

}
