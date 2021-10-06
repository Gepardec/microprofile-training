package com.gepardec.training.microprofile.basic.config;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.mvc.Controller;
import javax.mvc.Models;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

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
