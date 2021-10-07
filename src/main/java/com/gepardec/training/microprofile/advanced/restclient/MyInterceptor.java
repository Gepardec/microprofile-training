package com.gepardec.training.microprofile.advanced.restclient;

import org.eclipse.microprofile.rest.client.ext.AsyncInvocationInterceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class MyInterceptor implements AsyncInvocationInterceptor {

    private static final Logger log = LoggerFactory.getLogger(MyInterceptor.class);

    // This field is temporary storage to facilitate copying a ThreadLocal value
    volatile Integer value;

    @Override
    public void prepareContext() {
        log.info("prepare Context: {}", Thread.currentThread());
        value = AsyncController.getThreadLocalValue().get();
        log.info("prepare Context: Value of thread that invoked the call {}", value);
    }

    @Override
    public void applyContext() {
        log.info("apply Context: {}", Thread.currentThread());
        AsyncController.setThreadLocalValue(value);
        log.info("apply Context: Value of thread that invoked the call {}", value);
    }

    @Override
    public void removeContext() {
        log.info("remove Context: {}", Thread.currentThread());
        AsyncController.setThreadLocalValue(null);
        log.info("remove Context: Value of thread that invoked the call {}", value);
    }
}
