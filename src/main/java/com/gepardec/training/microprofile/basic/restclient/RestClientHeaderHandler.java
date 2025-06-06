package com.gepardec.training.microprofile.basic.restclient;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.ws.rs.core.MultivaluedHashMap;
import jakarta.ws.rs.core.MultivaluedMap;
import org.eclipse.microprofile.rest.client.ext.ClientHeadersFactory;
import org.slf4j.Logger;

import jakarta.inject.Inject;

@ApplicationScoped
public class RestClientHeaderHandler implements ClientHeadersFactory {

    @Inject
    private Logger log;

    @Override
    public MultivaluedMap<String, String> update(MultivaluedMap<String, String> incomingHeaders, MultivaluedMap<String, String> clientOutgoingHeaders) {
        incomingHeaders.forEach((key, value) -> log.info("Header: {} = {}", key, value));

        final var result = new MultivaluedHashMap<>(clientOutgoingHeaders);
        result.add("X-Custom-Header", "custom-value");
        return result;
    }
}
