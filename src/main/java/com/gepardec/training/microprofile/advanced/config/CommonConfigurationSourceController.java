package com.gepardec.training.microprofile.advanced.config;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.mvc.Controller;
import javax.mvc.Models;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/advanced/config/commonconfiguration")
@RequestScoped
public class CommonConfigurationSourceController {

    @Inject
    private Models model;

    @Path("/")
    @GET
    @Controller
    public String getCommonConfiguration() {
        model.put("work", callWorkHere());
        return "advanced/config/common-configuration.xhtml";
    }

    private String callWorkHere() {
        return "nothing done yet!";
    }
}
