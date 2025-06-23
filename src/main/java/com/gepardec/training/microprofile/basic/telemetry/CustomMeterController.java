package com.gepardec.training.microprofile.basic.telemetry;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.mvc.Controller;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("/basic/telemetry/custom-meter")
@RequestScoped
public class CustomMeterController {

    @Inject
    CustomMeterService customMeterService;

    @Controller
    @GET
    @Path("/")
    public String get() {
        customMeterService.countUp();
        return "basic/telemetry/custom-meter.xhtml";
    }
}
