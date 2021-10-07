package com.gepardec.training.microprofile.advanced.restclient;

import org.eclipse.microprofile.rest.client.ext.AsyncInvocationInterceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class MyInterceptor implements AsyncInvocationInterceptor {

    private static final Logger log = LoggerFactory.getLogger(MyInterceptor.class);

    // This field is temporary storage to facilitate copying a ThreadLocal value
    private volatile String someValue;

    @Override
    public void prepareContext() {
        log.info("prepare Context: {}", Thread.currentThread());
        someValue = AsyncController.getValue();
        log.info("prepare Context: Value of thread that invoked the call {}", someValue);
    }

    @Override
    public void applyContext() {
        log.info("apply Context: {}", Thread.currentThread());
        AsyncController.setValue(someValue);
        log.info("apply Context: Value of thread that invoked the call {}", someValue);
    }

    @Override
    public void removeContext() {
        log.info("remove Context: {}", Thread.currentThread());
        AsyncController.setValue(null);
        log.info("remove Context: Value of thread that invoked the call {}", someValue);
    }
}
