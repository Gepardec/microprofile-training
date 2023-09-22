package com.gepardec.training.microprofile.basic.restclient;

import org.eclipse.microprofile.rest.client.ext.ResponseExceptionMapper;

import javax.ws.rs.core.Response;

/**
 * Maps an error response of the rest client code to a RuntimeException which can be handled in your source code.
 */
public class RestClientExceptionMapper implements ResponseExceptionMapper<RuntimeException> {

    @Override
    public RuntimeException toThrowable(Response response) {
        if (response.getStatus() > 400) {
            return new RuntimeException("Exception occurred");
        }

        return null;
    }
}
