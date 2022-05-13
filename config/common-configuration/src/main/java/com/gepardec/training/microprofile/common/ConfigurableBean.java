package com.gepardec.training.microprofile.common;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.config.inject.ConfigProperty;

@ApplicationScoped
public class ConfigurableBean {

    @Inject
    @ConfigProperty(name = "common.key")
    private String commonConfigurationValue;

    public String doStuff() {
        return commonConfigurationValue;
    }
}
