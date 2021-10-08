package com.gepardec.training.microprofile.basic.restclient;

import org.eclipse.microprofile.rest.client.ext.ResponseExceptionMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.json.bind.JsonbException;
import javax.ws.rs.core.Response;

/**
 * Maps an error response of the rest client code to a RuntimeException which can be handled in your source code.
 */
public class RestClientExceptionMapper implements ResponseExceptionMapper<RuntimeException> {

    private static final Logger log = LoggerFactory.getLogger(RestClientExceptionMapper.class);

    @Override
    public RuntimeException toThrowable(Response response) {
        log.info("Mapping error response to RuntimeException. code: {}", response.getStatus());
        return null;
    }

    private String readEntity(final Response response) {
        try {
            return response.readEntity(String.class);
        } catch (JsonbException e) {
            return "could not deserialize entity";
        }
    }
}
