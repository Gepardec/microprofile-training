package com.gepardec.training.microprofile.advanced.config;

import org.eclipse.microprofile.config.spi.ConfigSource;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class DatabaseConfigSource implements ConfigSource {

    private final PropertyDao propertyDao = new PropertyDao();

    private Set<String> propertyNames;

    private Map<String, String> valueCache;

    @Override
    public Set<String> getPropertyNames() {
        if (propertyNames == null) {
            propertyNames = propertyDao.findPropertyNames();
        }
        return propertyNames;
    }

    @Override
    public String getValue(String s) {
        if (valueCache == null) {
            valueCache = new HashMap<>();
        }
        return valueCache.computeIfAbsent(s, propertyDao::findProperty);
    }

    @Override
    public String getName() {
        return "database";
    }
}
