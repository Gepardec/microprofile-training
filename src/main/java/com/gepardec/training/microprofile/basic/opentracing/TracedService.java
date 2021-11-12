package com.gepardec.training.microprofile.basic.opentracing;

import io.opentracing.Tracer;
import org.eclipse.microprofile.opentracing.Traced;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

@RequestScoped
public class TracedService {

    @Inject
    private Tracer tracer;

    @Inject
    private TracedService delegate;

    void auoTraced() {
        // Nothing to do here
    }

    /**
     * Here you put the code for the delegate calls on 'autoTraced()'
     */
    void invoke() {
        // TODO: Implement some calls to delegate#autoTraced(). Don't calls this method, otherwise you end up with end endless loop.
    }
}
