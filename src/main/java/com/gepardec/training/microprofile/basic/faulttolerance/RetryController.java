package com.gepardec.training.microprofile.basic.faulttolerance;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.mvc.Controller;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@RequestScoped
@Path("/basic/faulttolerance/retry")
public class RetryController {

    @Inject
    private RetryService retryService;

    @Controller
    @GET
    @Path("/")
    public String get() {
        return "basic/faulttolerance/retry.xhtml";
    }

    @POST
    @Path("/retried")
    public Response retried() {
        try {
            return Response.ok("Call worked with " + (retryService.retried() - 1) + " retries").build();
        } catch (Exception e) {
            return Response.serverError().entity(e.getMessage()).build();
        }
    }
}
