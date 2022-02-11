package com.gepardec.training.microprofile.dropinconfiguration;

import org.eclipse.microprofile.config.spi.ConfigSource;

import java.util.Set;

public class DropInConfigurationConfigSource implements ConfigSource {

    @Override
    public Set<String> getPropertyNames() {
        return DropInConfiguration.getProperties().keySet();
    }

    @Override
    public String getValue(String propertyName) {
        return DropInConfiguration.getProperties().get(propertyName);
    }

    @Override
    public String getName() {
        return "drop-in-configuration-configsource";
    }
}
