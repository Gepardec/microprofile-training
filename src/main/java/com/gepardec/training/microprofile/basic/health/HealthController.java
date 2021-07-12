package com.gepardec.training.microprofile.basic.health;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.mvc.Controller;
import javax.mvc.Models;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.QueryParam;

@Path("/basic/health")
@RequestScoped
@Controller
public class HealthController {

    @Inject
    Models models;

    @Inject
    HealthState healthState;


    @GET
    public String index(){
        return "basic/health/index.xhtml";
    }

    @Path("/response")
    @GET
    public String index(@QueryParam("question") Integer questionKey, @QueryParam("response") Integer responseKey) {
        healthState.respond(questionKey,responseKey);
        return "basic/health/index.xhtml";
    }

}
