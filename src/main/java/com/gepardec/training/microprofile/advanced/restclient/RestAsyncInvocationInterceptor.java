package com.gepardec.training.microprofile.advanced.restclient;

import org.eclipse.microprofile.rest.client.ext.AsyncInvocationInterceptor;

public class RestAsyncInvocationInterceptor implements AsyncInvocationInterceptor {

    private volatile Integer threadLocalValue;

    @Override
    public void prepareContext() {
        threadLocalValue = AsyncController.threadLocalValue.get();
    }

    @Override
    public void applyContext() {
        AsyncController.threadLocalValue.set(threadLocalValue);
    }

    @Override
    public void removeContext() {
        threadLocalValue = null;
    }
}
