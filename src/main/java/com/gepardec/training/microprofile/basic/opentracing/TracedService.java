package com.gepardec.training.microprofile.basic.opentracing;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;

/**
 * The traced methods shall be called in the {@link TracedController#index()}
 */
@RequestScoped
public class TracedService {

    @Inject
    private TracedService delegate;

    void traceMeOne() {
        // Nothing to do here
    }

    void traceMeTwo() {
        // Nothing to do here
    }
}
