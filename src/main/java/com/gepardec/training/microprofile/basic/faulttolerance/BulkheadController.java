package com.gepardec.training.microprofile.basic.faulttolerance;

import jakarta.enterprise.context.RequestScoped;
import jakarta.mvc.Controller;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;

@RequestScoped
@Path("/basic/faulttolerance/bulkhead")
public class BulkheadController {

    @Controller
    @GET
    @Path("/")
    public String get() {
        return "basic/faulttolerance/bulkhead.xhtml";
    }

    @POST
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/bulkheaded")
    public Response bulkheaded() throws InterruptedException {
        Thread.sleep(250);
        return Response.ok("Call worked").build();
    }
}
