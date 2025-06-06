package com.gepardec.training.microprofile.basic.restclient;

import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.rest.client.ext.ResponseExceptionMapper;

/**
 * Maps an error response of the rest client code to a RuntimeException which can be handled in your source code.
 */
public class RestClientExceptionMapper implements ResponseExceptionMapper<RuntimeException> {

    @Override
    public RuntimeException toThrowable(Response response) {
        return new RuntimeException("Rest client call failed");
    }
}
