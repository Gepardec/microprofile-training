package com.gepardec.training.microprofile.advanced.config;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.mvc.Controller;
import javax.mvc.Models;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/advanced/config/dropinconfiguration")
@RequestScoped
public class DtopInConfigurationController {

    @Inject
    private Models model;

    @Inject
    @ConfigProperty(name = "drop.in.key1", defaultValue = "Missing value from Drop-In ConfigSource")
    private String dropInValue1;

    @Inject
    @ConfigProperty(name = "drop.in.key2", defaultValue = "Missing value from Drop-In ConfigSource")
    private String dropInValue2;

    @Path("/")
    @GET
    @Controller
    public String getDropInConfiguration() {
        model.put("dropInValue1", dropInValue1);
        model.put("dropInValue2", dropInValue2);
        return "advanced/config/drop-in.xhtml";
    }
}
