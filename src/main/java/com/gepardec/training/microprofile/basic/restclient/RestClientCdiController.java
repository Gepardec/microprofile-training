package com.gepardec.training.microprofile.basic.restclient;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.mvc.Controller;
import jakarta.mvc.Models;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import java.util.Optional;

@Path("/basic/restclient/rest-client-cdi")
@RequestScoped
@Controller
public class RestClientCdiController {

    private HttpbinClientApi api;

    @Inject
    private Models model;

    @Path("/")
    @GET
    public String cdi() {
        model.put("value", Optional.ofNullable(api).map(HttpbinClientApi::get).orElse("no_response_yet"));
        return "basic/restclient/rest-client-cdi.xhtml";
    }
}
