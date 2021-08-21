package com.gepardec.training.microprofile.basic.faulttolerance;

import javax.enterprise.context.RequestScoped;
import javax.mvc.Controller;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

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
