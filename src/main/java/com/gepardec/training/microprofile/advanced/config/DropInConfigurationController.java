package com.gepardec.training.microprofile.advanced.config;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.mvc.Controller;
import jakarta.mvc.Models;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("/advanced/config/dropinconfiguration")
@RequestScoped
public class DropInConfigurationController {

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
