package com.gepardec.training.microprofile.basic.restclient;

import jakarta.enterprise.context.RequestScoped;
import jakarta.mvc.Controller;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.WebApplicationException;

@Path("/basic/restclient/exception-mapper")
@RequestScoped
public class ExceptionMapperController {

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
