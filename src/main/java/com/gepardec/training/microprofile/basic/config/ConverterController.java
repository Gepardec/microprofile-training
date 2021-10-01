package com.gepardec.training.microprofile.basic.config;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.mvc.Controller;
import javax.mvc.Models;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
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
