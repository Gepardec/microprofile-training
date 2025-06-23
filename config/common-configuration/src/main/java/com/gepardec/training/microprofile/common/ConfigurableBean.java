package com.gepardec.training.microprofile.common;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class ConfigurableBean {

    @Inject
    @ConfigProperty(name = "common.key")
    private String commonConfigurationValue;

    public String doStuff() {
        return commonConfigurationValue;
    }
}
