package com.gepardec.training.microprofile.basic.config;

import com.gepardec.training.microprofile.SystemHelper;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.mvc.Controller;
import jakarta.mvc.Models;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import org.eclipse.microprofile.config.inject.ConfigProperty;

@Path("/basic/config/env")
@RequestScoped
public class EnvController {

    @Inject
    private SystemHelper systemHelper;

    @Inject
    private Models model;

    @Inject
    @ConfigProperty(name = "env.application.name")
    private String appName;

    @Path("/")
    @GET
    @Controller
    public String getConfigFromEnvVariable() {
        // Environment variables for properties with syntax 'env.application.name' must have the form 'ENV_APPLICATION_NAME'
        final boolean envVar = systemHelper.isEnvVariable("ENV_APPLICATION_NAME");
        model.put("isEnv", envVar);
        if (!envVar) {
            model.put("envMessage", "Warning: Config is not provided via environment variable.");
        } else {
            model.put("envApplicationName", appName);
        }
        return "basic/config/env.xhtml";
    }
}
