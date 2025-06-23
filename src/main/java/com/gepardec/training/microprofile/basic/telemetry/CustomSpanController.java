package com.gepardec.training.microprofile.basic.telemetry;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.mvc.Controller;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Path("/basic/telemetry/custom-span")
@RequestScoped
public class CustomSpanController {

    @Inject
    CustomSpanService customSpanService;

    @Controller
    @GET
    @Path("/")
    public String get() {
        customSpanService.produceCustomSpan(LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME));
        return "basic/telemetry/custom-span.xhtml";
    }
}
