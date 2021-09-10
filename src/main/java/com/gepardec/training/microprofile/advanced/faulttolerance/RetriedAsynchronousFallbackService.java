package com.gepardec.training.microprofile.advanced.faulttolerance;

import org.slf4j.Logger;

import javax.enterprise.context.Dependent;
import javax.inject.Inject;
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
