package com.gepardec.training.microprofile.basic.restclient;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.mvc.Controller;
import jakarta.mvc.Models;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import org.eclipse.microprofile.rest.client.RestClientBuilder;

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
        final HttpbinClientApi api = RestClientBuilder.newBuilder().baseUri(uri).build(HttpbinClientApi.class); // Use the client builder to create the client instance

        return (api != null) ? api.get() : null;
    }
}
