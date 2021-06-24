package com.gepardec.training.microprofile.basic.restclient;

import org.eclipse.microprofile.rest.client.ext.ClientHeadersFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.ws.rs.core.MultivaluedHashMap;
import javax.ws.rs.core.MultivaluedMap;
import java.util.Collections;

public class RestClientHeaderHandler implements ClientHeadersFactory {

    private static final Logger log = LoggerFactory.getLogger(RestClientHeaderHandler.class);
    private static final Jsonb jsonb = JsonbBuilder.create();

    @Override
    public MultivaluedMap<String, String> update(MultivaluedMap<String, String> incomingHeaders,
                                                 MultivaluedMap<String, String> clientOutgoingHeaders) {
        log.info("Incoming Headers: %s", toJson(incomingHeaders));
        log.info("Outgoing Headers: %s", toJson(clientOutgoingHeaders));

        // Will be merged with outgoing headers
        return new MultivaluedHashMap<>() {{
            put("X-Test", Collections.singletonList("test header"));
        }};
    }

    private String toJson(final Object obj) {
        if (obj != null) {
            return JsonbBuilder.create().toJson(obj);
        } else {
            return "null";
        }
    }
}
