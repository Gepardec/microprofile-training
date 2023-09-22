package com.gepardec.training.microprofile.basic.config;

import org.eclipse.microprofile.config.inject.ConfigProperties;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.mvc.Controller;
import javax.mvc.Models;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/basic/config/propertyclass")
@RequestScoped
public class PropertyClassController {

    @Inject
    private Models model;

    @Inject
    @ConfigProperties
    private ServerConfig backendServerConfig;

    @Inject
    @ConfigProperties(prefix = "frontend")
    private ServerConfig frontendServerConfig;

    @Path("/")
    @GET
    @Controller
    public String getPropertyClass() {
        model.put("backendHost", backendServerConfig.getHost());
        model.put("backendPort", backendServerConfig.getPort());
        model.put("backendEndpoint", backendServerConfig.getEndpoint());

        model.put("frontendHost", frontendServerConfig.getHost());
        model.put("frontendPort", frontendServerConfig.getPort());
        model.put("frontendEndpoint", frontendServerConfig.getEndpoint());
        return "basic/config/property-class.xhtml";
    }
}
