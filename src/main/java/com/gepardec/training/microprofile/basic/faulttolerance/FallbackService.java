package com.gepardec.training.microprofile.basic.faulttolerance;

import jakarta.enterprise.context.Dependent;
import org.eclipse.microprofile.faulttolerance.Fallback;

@Dependent
public class FallbackService {

    @Fallback(fallbackMethod = "fallbackMethod")
    public String fails() {
        throw new IllegalStateException("I always fail, sorry :(");
    }

    private String fallbackMethod() {
        return "No fallback? Prepare to fall... back! 😵";
    }
}
