package com.gepardec.training.microprofile.advanced.config;

import java.util.HashMap;
import java.util.Map;

public class MyConfiguration {

    private static final Map<String, String> properties = new HashMap<>();

    static {
        properties.put("custom.value1", "Value 1 from MyConfiguration");
        properties.put("custom.value2", "Value 2 from MyConfiguration");
        properties.put("custom.value3", "Value 3 from MyConfiguration");
    }

    public static Map<String, String> getProperties() {
        return properties;
    }
}
