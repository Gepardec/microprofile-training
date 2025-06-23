package com.gepardec.training.microprofile.advanced.config;

import com.gepardec.training.microprofile.common.ConfigurableBean;
import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.mvc.Controller;
import jakarta.mvc.Models;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("/advanced/config/commonconfiguration")
@RequestScoped
public class CommonConfigurationSourceController {

    @Inject
    ConfigurableBean configurableBean;

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
        return configurableBean.doStuff();
    }
}
