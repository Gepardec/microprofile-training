package com.gepardec.training.microprofile.advanced.config;

import org.eclipse.microprofile.config.Config;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.mvc.Controller;
import javax.mvc.Models;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/config-advanced")
@RequestScoped
@Controller
public class AdvancedMPConfigController {

    @Inject
    private Models model;

    @Inject
    private Config config;

    @ConfigProperty(name = "custom.value1", defaultValue = "Missing value from custom ConfigSource")
    private String customValue1;

    @ConfigProperty(name = "custom.value2", defaultValue = "Missing value from custom ConfigSource")
    private String customValue2;

    @Path("/customconfigsource")
    @GET
    public String getCustomConfigSource() {
        model.put("customValue1", customValue1);
        model.put("customValue2", customValue2);
        return "advanced/config_custom_config_source.xhtml";
    }
}
