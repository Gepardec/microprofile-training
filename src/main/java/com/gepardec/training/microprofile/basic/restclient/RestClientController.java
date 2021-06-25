package com.gepardec.training.microprofile.basic.restclient;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.mvc.Controller;
import javax.mvc.Models;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.net.URISyntaxException;

@Path("/basic/restclient")
@RequestScoped
@Controller
public class RestClientController {

    @Inject
    private Models model;

    @Inject
    private RestClientCdi restClientCdi;


    @Path("/")
    @GET
    public String get() {
        return restClient();
    }

    @Path("/index")
    @GET
    public String restClient() {
        return "basic/restclient/index.xhtml";
    }

    @Path("/restClientBuilder")
    @GET
    public String restClientBuilder() throws URISyntaxException {
        UseRestClientBuilder restClientBuilder = new UseRestClientBuilder();
        model.put("value", restClientBuilder.welcomeMessage());
        return "basic/restclient/restClientBuilder.xhtml";
    }

    @Path("/cdi")
    @GET
    public String cdi() {
        model.put("value", restClientCdi.welcomeMessage());
        return "basic/restclient/cdi.xhtml";
    }

    @Path("/exceptionHandling")
    @GET
    public String exceptionHandling() {
            model.put("value", restClientCdi.invalid());
        return "basic/restclient/exceptionMapping.xhtml";
    }

    @Path("/headersFactory")
    @GET
    public String headersFactory() {
        //    model.put("value", restClientCdi.callCheetahService());
        return "basic/restclient/headersFactory.xhtml";
    }
}
