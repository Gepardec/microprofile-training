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
        model.put("envApplicationName", appName);
        model.put("isEnv", systemHelper.isEnvVariable("env.application.name"));
        if (!systemHelper.isEnvVariable("env.application.name") || (systemHelper.isEnvVariable("env.application.name") && systemHelper.isSystemProperty(
                "env.application.name")))
            model.put("envMessage", "Warning: Config is not provided via environment variable.");
        return "basic/config/env.xhtml";
    }
}
