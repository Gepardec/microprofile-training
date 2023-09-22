package com.gepardec.training.microprofile.basic.config;

import org.eclipse.microprofile.config.inject.ConfigProperties;

import javax.enterprise.context.Dependent;

@ConfigProperties(prefix="backend")
@Dependent
public class ServerConfig {

    private String host = "Configure me";

    private String port = "Configure me";

    private String endpoint = "Configure me";

    public String getHost() {
        return host;
    }

    public String getPort() {
        return port;
    }

    public String getEndpoint() {
        return endpoint;
    }

}
