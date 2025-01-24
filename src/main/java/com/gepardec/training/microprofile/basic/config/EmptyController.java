package com.gepardec.training.microprofile.basic.config;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.mvc.Controller;
import jakarta.mvc.Models;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("/basic/config/empty")
@RequestScoped
public class EmptyController {

    @Inject
    @ConfigProperty(name = "property.empty", defaultValue = "I should be empty")
    private String emptyValue;

    @Inject
    private Models model;

    @Path("/")
    @GET
    @Controller
    public String getEmptyValue() {
        model.put("emptyValue", emptyValue);
        return "basic/config/empty.xhtml";
    }
}
