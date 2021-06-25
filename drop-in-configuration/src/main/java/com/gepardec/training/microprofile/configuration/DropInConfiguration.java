package com.gepardec.training.microprofile.configuration;

import java.util.HashMap;
import java.util.Map;

public class DropInConfiguration {

    private static final Map<String, String> properties = new HashMap<>();

    static {
        properties.put("drop.in.value1", "Value 1 from DropInConfiguration");
        properties.put("drop.in.value2", "Value 2 from DropInConfiguration");
        properties.put("drop.in.value3", "Value 3 from DropInConfiguration");
    }

    public static Map<String, String> getProperties() {
        return properties;
    }
}
