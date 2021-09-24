package com.gepardec.training.microprofile.advanced.config;

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
    @ConfigProperty(name = "db.key1", defaultValue = "Missing value from custom ConfigSource")
    private String customValue1;

    @Inject
    @ConfigProperty(name = "db.key2", defaultValue = "Missing value from custom ConfigSource")
    private String customValue2;

    @Inject
    @ConfigProperty(name = "drop.in.key1", defaultValue = "Missing value from Drop-In ConfigSource")
    private String dropInValue1;

    @Inject
    @ConfigProperty(name = "drop.in.key2", defaultValue = "Missing value from Drop-In ConfigSource")
    private String dropInValue2;

    @Path("/customconfigsource")
    @GET
    public String getCustomConfigSource() {
        model.put("customValue1", customValue1);
        model.put("customValue2", customValue2);
        return "advanced/config/custom_config_source.xhtml";
    }

    @Path("/dropinconfiguration")
    @GET
    public String getDropInConfiguration() {
        model.put("dropInValue1", dropInValue1);
        model.put("dropInValue2", dropInValue2);
        return "advanced/config/drop_in.xhtml";
    }

    @Path("/commonconfiguration")
    @GET
    public String getCommonConfiguration() {
        return "advanced/config/common_configuration.xhtml";
    }
}
