package com.gepardec.training.microprofile.advanced.restclient;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.ws.rs.client.ClientRequestContext;
import javax.ws.rs.client.ClientRequestFilter;
import java.io.IOException;


public class MyClientRequestFilter implements ClientRequestFilter {

    private static final Logger log = LoggerFactory.getLogger(MyClientRequestFilter.class);

    volatile Integer  value;
    @Override
    public void filter(ClientRequestContext clientRequestContext) throws IOException {
        value = AsyncController.getThreadLocalValue().get();
        log.info("ClientRequestFilter: localThread value {}", value);
    }
}
