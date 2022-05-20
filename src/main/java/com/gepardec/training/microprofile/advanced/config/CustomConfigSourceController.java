package com.gepardec.training.microprofile.advanced.config;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.mvc.Controller;
import jakarta.mvc.Models;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import org.eclipse.microprofile.config.inject.ConfigProperty;

@Path("/advanced/config/customconfigsource")
@RequestScoped
public class CustomConfigSourceController {

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
