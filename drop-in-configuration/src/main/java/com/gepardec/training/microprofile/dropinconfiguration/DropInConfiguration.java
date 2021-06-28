package com.gepardec.training.microprofile.dropinconfiguration;

import java.util.HashMap;
import java.util.Map;

public class DropInConfiguration {

    private static final Map<String, String> properties = new HashMap<>();

    static {
        properties.put("drop.in.key1", "Value 1 from DropInConfiguration");
        properties.put("drop.in.key2", "Value 2 from DropInConfiguration");
        properties.put("drop.in.key3", "Value 3 from DropInConfiguration");
    }

    public static Map<String, String> getProperties() {
        return properties;
    }
}
