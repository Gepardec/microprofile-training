package com.gepardec.training.microprofile.basic.faulttolerance;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.mvc.Controller;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;
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
        // TODO: Go to 'AsynchronousService#invoke' and make the invocations really asynchronous
        // TODO: The logs will tell you if the invocations were asynchronous
        final List<Future<Void>> futures = List.of(
                asynchronousService.invoke(),
                asynchronousService.invoke(),
                asynchronousService.invoke(),
                asynchronousService.invoke(),
                asynchronousService.invoke());
        // We have Futures, so we need to wait for all of them before we return the result
        boolean run = true;
        while (run) {
            Thread.onSpinWait();
            run = !futures.stream().allMatch(Future::isDone);
        }

        return Response.ok().build();
    }
}
