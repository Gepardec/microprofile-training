package com.gepardec.training.microprofile.advanced.faulttolerance;

import org.eclipse.microprofile.faulttolerance.Asynchronous;
import org.eclipse.microprofile.faulttolerance.Fallback;
import org.eclipse.microprofile.faulttolerance.Retry;
import org.slf4j.Logger;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.CompletionStage;

@Dependent
public class RetriedAsynchronousFallbackService {

    @Inject
    private Logger log;

    private int counter = 0;

    @Asynchronous
    @Fallback(fallbackMethod = "fallbackMethod")
    @Retry(maxRetries = 1) // @Retry(maxRetries = 1)
    public CompletionStage<Integer> invoke() {
        counter++;
        final CompletableFuture<Integer> result = new CompletableFuture<>();
        if (counter < 4) {
            result.completeExceptionally(new IllegalArgumentException("Invocation count: " + counter));
        } else {
            result.complete(counter);
        }

        return result;
    }

    public CompletionStage<Integer> fallbackMethod() {
        return CompletableFuture.completedFuture(42);
    }
}
