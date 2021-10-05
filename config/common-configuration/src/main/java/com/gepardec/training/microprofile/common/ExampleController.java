package com.gepardec.training.microprofile.common;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.mvc.Controller;
import javax.mvc.Models;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/advanced/config")
@RequestScoped
@Controller
public class ExampleController {

    @Inject
    private Models model;

    @Inject
    @ConfigProperty(name = "common.key")
    private String commonConfigurationValue;

    @Path("/commonconfigurationexternal")
    @GET
    public String getConfigFromPropertyFile() {
        model.put("value", commonConfigurationValue);
        return "advanced/config/common_configuration_result.xhtml";
    }

}
