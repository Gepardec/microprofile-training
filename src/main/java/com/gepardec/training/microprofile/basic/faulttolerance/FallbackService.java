package com.gepardec.training.microprofile.basic.faulttolerance;

import org.eclipse.microprofile.faulttolerance.Fallback;

import javax.enterprise.context.Dependent;

@Dependent
public class FallbackService {

    @Fallback(fallbackMethod = "fallbackMethod")
    public String fails() {
        throw new IllegalStateException("I always fail, sorry :(");
    }

    public String fallbackMethod() {
        return "This is a fallback";
    }
}
