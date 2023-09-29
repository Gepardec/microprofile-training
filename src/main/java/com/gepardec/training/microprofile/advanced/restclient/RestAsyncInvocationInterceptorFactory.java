package com.gepardec.training.microprofile.advanced.restclient;

import org.eclipse.microprofile.rest.client.ext.AsyncInvocationInterceptor;
import org.eclipse.microprofile.rest.client.ext.AsyncInvocationInterceptorFactory;

public class RestAsyncInvocationInterceptorFactory implements AsyncInvocationInterceptorFactory {


    @Override
    public AsyncInvocationInterceptor newInterceptor() {
        return new RestAsyncInvocationInterceptor();
    }
}