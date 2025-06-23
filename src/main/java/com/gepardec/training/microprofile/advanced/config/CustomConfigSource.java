package com.gepardec.training.microprofile.advanced.config;

import org.eclipse.microprofile.config.spi.ConfigSource;

import java.util.Set;

public class CustomConfigSource implements ConfigSource {

    private PropertyDao propertyDao = new PropertyDao();

    @Override
    public Set<String> getPropertyNames() {
        return propertyDao.findPropertyNames();
    }

    @Override
    public String getValue(String key) {
       return propertyDao.findProperty(key);
    }

    @Override
    public String getName() {
        return "database-config-source";
    }
}
