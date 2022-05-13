package com.gepardec.training.microprofile.basic.config;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.mvc.Controller;
import jakarta.mvc.Models;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import java.math.BigDecimal;

@Path("/basic/config/converter")
@RequestScoped
public class ConverterController {

    @Inject
    @ConfigProperty(name = "converter.value1")
    private BigDecimal value1;

    @Inject
    @ConfigProperty(name = "converter.value2")
    private BigDecimal value2;

    @Inject
    private Models model;

    @Path("/")
    @GET
    @Controller
    public String getConverter() {
        model.put("value1", value1);
        model.put("value2", value2);
        return "basic/config/converter.xhtml";
    }
}
