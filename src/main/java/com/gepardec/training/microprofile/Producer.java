package com.gepardec.training.microprofile;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.enterprise.context.ApplicationScoped;
import javax.enterprise.inject.Produces;
import javax.enterprise.inject.spi.InjectionPoint;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.ServletContext;

@ApplicationScoped
public class Producer {

    @Inject
    private ServletContext servletContext;

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

    @Produces
    @ApplicationScoped
    @Named("basePath")
    String createBasePath() {
        return servletContext.getContextPath() + "/api";
    }
}
