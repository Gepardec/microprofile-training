package com.gepardec.training.microprofile.advanced.restclient;

import jakarta.inject.Inject;
import jakarta.ws.rs.client.ClientRequestContext;
import jakarta.ws.rs.client.ClientRequestFilter;
import jakarta.ws.rs.ext.Provider;
import org.slf4j.Logger;

import java.io.IOException;
import java.util.Optional;

@Provider
public class AsyncClientRequestFilter implements ClientRequestFilter {

    @Inject
    Logger logger;

    @Override
    public void filter(ClientRequestContext clientRequestContext) throws IOException {
        ThreadLocal<Integer> threadLocalValue = AsyncController.threadLocalValue;
        logger.info("AsyncClientRequestFilter threadLocalValue: {}", threadLocalValue.get());
        clientRequestContext.getHeaders().putSingle("AsyncClientRequestFilter-threadLocalValue", threadLocalValue.get());
    }
}
