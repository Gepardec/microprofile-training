package com.gepardec.training.microprofile.basic.restclient;

import org.eclipse.microprofile.rest.client.ext.ClientHeadersFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.json.bind.JsonbBuilder;
import javax.ws.rs.core.MultivaluedMap;

public class RestClientHeaderHandler implements ClientHeadersFactory {

    private static final Logger log = LoggerFactory.getLogger(RestClientHeaderHandler.class);

    @Override
    public MultivaluedMap<String, String> update(MultivaluedMap<String, String> incomingHeaders,
            MultivaluedMap<String, String> clientOutgoingHeaders) {
        log.info("Incoming Headers: {}", toJson(incomingHeaders));
        log.info("Outgoing Headers: {}", toJson(clientOutgoingHeaders));

        //   Will be merged with outgoing headers
        return clientOutgoingHeaders;
    }

    private String toJson(final Object obj) {
        if (obj != null) {
            return JsonbBuilder.create().toJson(obj);
        } else {
            return "null";
        }
    }
}
