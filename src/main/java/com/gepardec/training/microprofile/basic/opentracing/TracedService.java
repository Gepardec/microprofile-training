package com.gepardec.training.microprofile.basic.opentracing;

import org.eclipse.microprofile.opentracing.Traced;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

/**
 * The traced methods shall be called in the {@link TracedController#index()}
 */
@RequestScoped
@Traced
public class TracedService {

    @Inject
    private TracedService delegate;

    @Traced(false)
    void traceMeOne() {
        delegate.traceMeTwo();
        // Nothing to do here
    }

    @Traced(operationName = "newTracingOperation")
    void traceMeTwo() {
        // Nothing to do here
    }
}
