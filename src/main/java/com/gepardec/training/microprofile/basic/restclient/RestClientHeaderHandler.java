package com.gepardec.training.microprofile.basic.restclient;

import org.eclipse.microprofile.rest.client.ext.ClientHeadersFactory;
import org.slf4j.Logger;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.core.MultivaluedMap;
import java.util.List;

@RequestScoped
public class RestClientHeaderHandler implements ClientHeadersFactory {

    @Inject
    private Logger log;

    @Override
    public MultivaluedMap<String, String> update(MultivaluedMap<String, String> incomingHeaders, MultivaluedMap<String, String> clientOutgoingHeaders) {
        incomingHeaders.keySet()
                .forEach(key -> log.info("{}: {}", key, String.join(",", incomingHeaders.get(key))));

        clientOutgoingHeaders.put("my-new-key", List.of("my-value"));

        return clientOutgoingHeaders;
    }
}
