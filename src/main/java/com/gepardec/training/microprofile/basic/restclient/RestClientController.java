package com.gepardec.training.microprofile.basic.restclient;

import javax.enterprise.context.RequestScoped;
import javax.mvc.Controller;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/basic/restclient")
@RequestScoped
@Controller
public class RestClientController {

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
}
