package com.gepardec.training.microprofile.basic.faulttolerance;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.mvc.Controller;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;
import java.util.List;
import java.util.concurrent.Future;

@Path("/basic/faulttolerance/asynchronous")
@RequestScoped
public class AsynchronousController {

    @Inject
    private AsynchronousService asynchronousService;

    @Controller
    @GET
    @Path("/")
    public String get() {
        return "basic/faulttolerance/asynchronous.xhtml";
    }

    @POST
    @Path("/async")
    public Response async() {
        final List<Future<Void>> futures = List.of(
                asynchronousService.longRunning(),
                asynchronousService.longRunning(),
                asynchronousService.longRunning(),
                asynchronousService.longRunning(),
                asynchronousService.longRunning());
        boolean run = true;
        while (run) {
            Thread.onSpinWait();
            run = !futures.stream().allMatch(Future::isDone);
        }

        return Response.ok().build();
    }
}
