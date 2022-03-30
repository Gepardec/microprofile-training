package com.gepardec.training.microprofile.basic.restclient;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.mvc.Controller;
import javax.mvc.Models;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
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
