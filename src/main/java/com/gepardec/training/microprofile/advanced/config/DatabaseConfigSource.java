package com.gepardec.training.microprofile.advanced.config;

import org.eclipse.microprofile.config.spi.ConfigSource;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class DatabaseConfigSource implements ConfigSource {

    private PropertyDao propertyDao = new PropertyDao();

    private Set<String> propertyNames = null;

    private Map<String, String> valueCache = new HashMap<>();

    @Override
    public Set<String> getPropertyNames() {
        if (propertyNames == null) {
            propertyNames = propertyDao.findPropertyNames();
        }
        return propertyNames;
    }

    @Override
    public String getValue(String s) {
        if (!valueCache.containsKey(s)) {
            valueCache.put(s, propertyDao.findProperty(s));
        }
        return valueCache.get(s);
    }

    @Override
    public String getName() {
        return "database";
    }
}
