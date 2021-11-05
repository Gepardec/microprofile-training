package com.gepardec.training.microprofile.basic.opentracing;

import io.opentracing.Tracer;
import org.eclipse.microprofile.opentracing.Traced;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

@RequestScoped
public class TracerService {

    @Inject
    private Tracer tracer;

    @Inject
    private TracerService delegate;

    /**
     * Traced by the interceptor
     */
    @Traced
    void auoTraced() {
        // Nothing to do here
    }

    /**
     * Here you put the code for the custom span
     */
    void customTraced() {
        // TODO: 1. Create a new Span
        // TODO: 2. Set the custom tag

        // Via the CDI proxy call the via @Traced annotated method, so we get a new span
        delegate.auoTraced();

        // TODO: 3. Finish the span
    }
}
