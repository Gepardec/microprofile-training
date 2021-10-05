package com.gepardec.training.microprofile.basic.health;

import io.smallrye.health.registry.LivenessHealthRegistry;
import org.eclipse.microprofile.health.HealthCheck;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Any;
import javax.enterprise.inject.Instance;
import javax.enterprise.inject.spi.BeanManager;
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
    BeanManager beanManager;

    @Inject
    @Any
    LivenessHealthRegistry livenessHealthRegistry;

    @Inject
    @Any
    Instance<HealthCheck> healthChecks;

    @Inject
    Models models;

    @Inject
    HealthState healthState;

    @Path("/")
    @GET
    public String get() {
        return index();
    }

    @Path("/response")
    @GET
    public String response(@QueryParam("question") Integer questionKey, @QueryParam("response") Integer responseKey) {
        healthState.takeUserResponse(questionKey, responseKey);
        return index();
    }

    @Path("/check")
    @GET
    public String check(@QueryParam("question") Integer questionKey) {
        healthChecks.toString();
        healthState.checkTaskDone(questionKey, healthChecks);
        return index();
    }

    @Path("/index")
    @GET
    public String index() {
        return "basic/health/index.xhtml";
    }

}
