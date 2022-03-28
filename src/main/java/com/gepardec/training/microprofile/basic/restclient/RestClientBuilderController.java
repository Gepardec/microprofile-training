package com.gepardec.training.microprofile.basic.restclient;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.mvc.Controller;
import javax.mvc.Models;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Optional;

@Path("/basic/restclient/rest-client-builder")
@RequestScoped
@Controller
public class RestClientBuilderController {

    @Inject
    private Models model;

    @Path("/")
    @GET
    public String get() throws URISyntaxException {
        model.put("value", Optional.ofNullable(createAndCallClient()).orElse("no_response_yet"));
        return "basic/restclient/rest-client-builder.xhtml";

    }

    private String createAndCallClient() throws URISyntaxException {
        final URI uri = new URI("https://httpbin.org/");
        final HttpbinClientApi api = null; // Use the client builder to create the client instance

        return (api != null) ? api.get() : null;
    }
}
