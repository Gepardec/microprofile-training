package com.gepardec.training.microprofile.basic.faulttolerance;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.mvc.Controller;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

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
            return Response.ok("Call worked with " + retryService.retried() + " retries").build();
        } catch (Exception e) {
            return Response.serverError().entity(e.getMessage()).build();
        }
    }
}
