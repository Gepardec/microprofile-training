package com.gepardec.training.microprofile;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.inject.Produces;
import jakarta.enterprise.inject.spi.InjectionPoint;

@ApplicationScoped
public class Producer {

    @Produces
    public Logger produceLogger(InjectionPoint injectionPoint) {
        // There are some cases when this can be null, for instance with EJBs
        if (injectionPoint.getBean() != null) {
            return LoggerFactory.getLogger(injectionPoint.getBean().getBeanClass());
        }
        // Should not be null, but we want to be safe
        else if (injectionPoint.getMember() != null) {
            return LoggerFactory.getLogger(injectionPoint.getMember().getDeclaringClass());
        }
        // In case we cannot determine declaring class
        else {
            return LoggerFactory.getLogger("default");
        }
    }
}
