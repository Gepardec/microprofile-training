package com.gepardec.training.microprofile.advanced.faulttolerance;

import jakarta.enterprise.context.Dependent;
import jakarta.inject.Inject;
import org.slf4j.Logger;

import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Future;

@Dependent
public class RetriedAsynchronousFallbackService {

    @Inject
    private Logger log;

    private int counter = 0;

    public Future<Integer> invoke() {
        counter++;
        final CompletableFuture<Integer> result = new CompletableFuture<>();
        if (counter < 4) {
            result.completeExceptionally(new IllegalArgumentException("Invocation count: " + counter));
        } else {
            result.complete(counter);
        }

        return result;
    }
}
