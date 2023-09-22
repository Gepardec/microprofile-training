package com.gepardec.training.microprofile.advanced.restclient;

import org.slf4j.Logger;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.ws.rs.client.ClientRequestContext;
import javax.ws.rs.client.ClientRequestFilter;
import java.io.IOException;

@ApplicationScoped
public class AsyncControllerRequestFilter implements ClientRequestFilter {

    @Inject
    Logger log;

    @Override
    public void filter(ClientRequestContext clientRequestContext) throws IOException {
        if (clientRequestContext.getHeaders().containsKey("threadLocalValue")) {
            log.info("Thread: {}", clientRequestContext.getHeaders().get("threadLocalValue"));
            clientRequestContext.getHeaders().put("threadLocalValue", clientRequestContext.getHeaders().get("threadLocalValue"));
        }
    }
}
