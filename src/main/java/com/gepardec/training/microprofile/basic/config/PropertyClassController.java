package com.gepardec.training.microprofile.basic.config;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.mvc.Controller;
import jakarta.mvc.Models;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("/basic/config/propertyclass")
@RequestScoped
public class PropertyClassController {

    @Inject
    private Models model;

    private ServerConfig backendServerConfig = new ServerConfig();

    private ServerConfig frontendServerConfig = new ServerConfig();

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
