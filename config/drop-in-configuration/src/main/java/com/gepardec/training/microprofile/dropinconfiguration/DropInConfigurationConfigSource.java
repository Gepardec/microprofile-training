package com.gepardec.training.microprofile.dropinconfiguration;

import org.eclipse.microprofile.config.spi.ConfigSource;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class DropInConfigurationConfigSource implements ConfigSource {

    private static final Map<String, String> properties = new HashMap<>();

    static {
        properties.put("drop.in.key1", "Value 1 from DropInConfiguration");
        properties.put("drop.in.key2", "Value 2 from DropInConfiguration");
        properties.put("drop.in.key3", "Value 3 from DropInConfiguration");
    }

    @Override
    public Set<String> getPropertyNames() {
        return properties.keySet();
    }

    @Override
    public String getValue(String propertyName) {
        return properties.get(propertyName);
    }

    @Override
    public String getName() {
        return "drop-in-configuration-configsource";
    }
}
