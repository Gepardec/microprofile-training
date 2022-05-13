package com.gepardec.training.microprofile.basic.metrics;

import jakarta.enterprise.context.RequestScoped;
import jakarta.mvc.Controller;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("/basic/metrics")
@RequestScoped
public class GrafanaController {

    @Path("/grafana")
    @GET
    @Controller
    public String getGrafana() {
        return "basic/metrics/grafana.xhtml";
    }

}
