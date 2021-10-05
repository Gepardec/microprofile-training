package com.gepardec.training.microprofile.advanced.config;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.mvc.Controller;
import javax.mvc.Models;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/advanced/config/customconfigsource")
@RequestScoped
public class CustomConfigSource {

    @Inject
    private Models model;

    @Inject
    @ConfigProperty(name = "db.key1", defaultValue = "Missing value from custom ConfigSource")
    private String dbKey1;

    @Inject
    @ConfigProperty(name = "db.key2", defaultValue = "Missing value from custom ConfigSource")
    private String dbKey2;

    @Path("/")
    @GET
    @Controller
    public String getCustomConfigSource() {
        model.put("customValue1", dbKey1);
        model.put("customValue2", dbKey2);
        return "advanced/config/custom-config-source.xhtml";
    }
}
