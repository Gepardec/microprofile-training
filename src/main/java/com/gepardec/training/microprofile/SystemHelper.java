package com.gepardec.training.microprofile;

import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class SystemHelper {

    public boolean isSystemProperty(String name) {
        return System.getProperty(name) != null && !System.getProperty(name).isBlank();
    }

    public boolean isEnvVariable(String name) {
        return System.getenv(name) != null && !System.getenv(name).isBlank() && !isSystemProperty(name);
    }
}
