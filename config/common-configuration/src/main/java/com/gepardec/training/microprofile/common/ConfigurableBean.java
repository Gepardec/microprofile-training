package com.gepardec.training.microprofile.common;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
public class ConfigurableBean {

    @Inject
    @ConfigProperty(name = "common.key")
    private String commonConfigurationValue;

    public String doStuff() {
        return commonConfigurationValue;
    }
}
