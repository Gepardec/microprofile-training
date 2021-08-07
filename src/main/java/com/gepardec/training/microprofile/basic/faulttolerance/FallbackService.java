package com.gepardec.training.microprofile.basic.faulttolerance;

import javax.enterprise.context.Dependent;

@Dependent
public class FallbackService {

    public String failsWithFallback() {
        throw new IllegalStateException("I always fail, so fix me with a fallback");
    }

    private String fallback() {
        return "I am the fallback result";
    }
}
