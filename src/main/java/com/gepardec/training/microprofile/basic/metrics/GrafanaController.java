package com.gepardec.training.microprofile.basic.metrics;

import javax.enterprise.context.RequestScoped;
import javax.mvc.Controller;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

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
