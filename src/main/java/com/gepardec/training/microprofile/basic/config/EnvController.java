package com.gepardec.training.microprofile.basic.config;

import com.gepardec.training.microprofile.SystemHelper;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.mvc.Controller;
import javax.mvc.Models;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/basic/config/env")
@RequestScoped
public class EnvController {

    @Inject
    private SystemHelper systemHelper;

    @Inject
    private Models model;

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
