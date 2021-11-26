package com.gepardec.training.microprofile.basic.restclient;

import org.slf4j.Logger;

import javax.inject.Inject;

/**
 * Maps an error response of the rest client code to a RuntimeException which can be handled in your source code.
 */
public class RestClientExceptionMapper {

    @Inject
    private Logger log;
    //Implement ResponseExceptionMapper
}
