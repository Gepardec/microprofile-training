package com.gepardec.training.microprofile.basic.opentracing;

import javax.enterprise.context.RequestScoped;

/**
 * Try to trace all methods or selective ones and take a look at the JaegerUI to see your traces.
 * The methods are called in the {@link TracerController#index()}
 */
@RequestScoped
public class TracedService {

    void autoTracedOne() {
    }

    void autoTracedTwo() {
    }
}
