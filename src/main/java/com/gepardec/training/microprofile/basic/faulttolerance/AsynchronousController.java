package com.gepardec.training.microprofile.basic.faulttolerance;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.mvc.Controller;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@Path("/basic/faulttolerance/asynchronous")
@RequestScoped
@Controller
public class AsynchronousController {

    @Inject
    private AsynchronousService asynchronousService;

    @GET
    @Path("/")
    public String get() {
        return "basic/faulttolerance/asynchronous.xhtml";
    }

    @POST
    @Path("/future")
    public String future() {
        // TODO: Go to 'AsynchronousService#invoke' and make the invocations asynchronous
        final List<Future<Void>> futures = List.of(
                asynchronousService.invoke(),
                asynchronousService.invoke(),
                asynchronousService.invoke(),
                asynchronousService.invoke());
        for (final Future<Void> future : futures) {
            try {
                future.get();
            } catch (InterruptedException | ExecutionException e) {
                throw new IllegalStateException("Could not wait for futures", e);
            }
        }

        return get();
    }

}
