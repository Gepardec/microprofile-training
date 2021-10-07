package com.gepardec.training.microprofile.advanced.restclient;

import org.eclipse.microprofile.rest.client.inject.RestClient;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.mvc.Controller;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/advanced/restclient/async")
@RequestScoped
public class AsyncController {

    @Inject
    @RestClient
    RestClientAPIAdvanced restClientAPIAdvanced;

    static ThreadLocal<Integer> threadLocalValue;

    @Path("/")
    @GET
    @Controller
    public String async() {
        return "advanced/restclient/async.xhtml";
    }

    @POST
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/getAsync")
    public Response getAsync() {

        //:TODO uncomment if you adapted the interface
        /*
        final var latch = new CountDownLatch(3);
        var s = new StringBuilder();
        final AtomicReference<Throwable> throwable = new AtomicReference<>();
        BiConsumer<String, Throwable> consumer = (r, t) -> {
            if (t != null) {
                throwable.set(t);
            } else {
                s.append(r);
            }
            latch.countDown();
        };
        threadLocalValue = new ThreadLocal<>();
        threadLocalValue.set(1);
        restClientAPIAdvanced.getAsync().whenCompleteAsync(consumer);
        threadLocalValue.set(2);
        restClientAPIAdvanced.getAsync().whenCompleteAsync(consumer);
        threadLocalValue.set(3);
        restClientAPIAdvanced.getAsync().whenCompleteAsync(consumer);
        try {
            latch.await();
        } catch (InterruptedException ex) {
            throw new WebApplicationException(ex, 500);
        }
        var t = throwable.get();
        if (t != null) {
            throw new WebApplicationException("Failure in downstream service",
                    t, 500);
        }
        return Response.ok(s.toString()).build();
        */

        return Response.noContent().build();
    }

    @POST
    @Produces(MediaType.TEXT_PLAIN)
    @Path("/getSync")
    public Response getSync() {
        final String s = restClientAPIAdvanced.get();
        final String s1 = restClientAPIAdvanced.get();
        final String s2 = restClientAPIAdvanced.get();
        return Response.ok(s + s1 + s + s2).build();

    }
}
