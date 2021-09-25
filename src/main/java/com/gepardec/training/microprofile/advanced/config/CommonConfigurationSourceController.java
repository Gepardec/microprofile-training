package com.gepardec.training.microprofile.advanced.config;

import javax.enterprise.context.RequestScoped;
import javax.mvc.Controller;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/advanced/config/commonconfiguration")
@RequestScoped
public class CommonConfigurationSourceController {

    @Path("/")
    @GET
    @Controller
    public String getCommonConfiguration() {
        return "advanced/config/common-configuration.xhtml";
    }
}
