package com.gepardec.training.microprofile.advanced.restclient;

import org.eclipse.microprofile.rest.client.ext.AsyncInvocationInterceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public class MyInterceptor implements AsyncInvocationInterceptor {

    private static final Logger log = LoggerFactory.getLogger(MyInterceptor.class);

    // This field is temporary storage to facilitate copying a ThreadLocal value
    Integer value;

    @Override
    public void prepareContext() {
        value = AsyncController.threadLocalValue.get();
        log.info("prepare Context Thread {}: Value of thread that invoked the call {}",Thread.currentThread(), value);
    }

    @Override
    public void applyContext() {
        AsyncController.threadLocalValue.set(value);
        log.info("apply Context Thread {}: Value of thread that invoked the call {}",Thread.currentThread(), value);
    }

    @Override
    public void removeContext() {
        AsyncController.threadLocalValue.remove();
        log.info("remove Context Thread {}: Value of thread that invoked the call {}",Thread.currentThread(), value);
    }
}
