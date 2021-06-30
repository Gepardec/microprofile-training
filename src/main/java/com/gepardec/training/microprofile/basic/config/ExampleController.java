package com.gepardec.training.microprofile.basic.config;

import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.mvc.Controller;
import javax.mvc.Models;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.math.BigDecimal;


@Path("/basic/config")
@RequestScoped
@Controller
public class ExampleController {

    @Inject
    private Models model;

    private String appNameFromPropertyFile;

    private String appNameFromSysProperty;

    private String appNameFromEnvVariable;

    @Inject
    @ConfigProperty(name = "converter.value1")
    private BigDecimal value1;

    @Inject
    @ConfigProperty(name = "converter.value2")
    private BigDecimal value2;

    @Inject
    @ConfigProperty(name = "property.empty", defaultValue = "I should be empty")
    private String emptyValue;

    private ServerConfig backendServerConfig = new ServerConfig();

    private ServerConfig frontendServerConfig = new ServerConfig();

    @Path("/file")
    @GET
    public String getConfigFromPropertyFile() {
        model.put("applicationName", appNameFromPropertyFile);
        if(isEnvVariable("file.application.name") || isSystemProperty("file.application.name")) {
            model.put("fileMessage", "Warning: Config is not provided via environment variable.");
        }
        return "basic/config/file.xhtml";
    }

    @Path("/env")
    @GET
    public String getConfigFromEnvVariable() {
        model.put("envApplicationName", appNameFromEnvVariable);
        model.put("isEnv", isEnvVariable("env.application.name"));
        if (!isEnvVariable("env.application.name") || (isEnvVariable("env.application.name") && isSystemProperty("env.application.name")))
            model.put("envMessage", "Warning: Config is not provided via environment variable.");
        return "basic/config/env.xhtml";
    }

    @Path("/sys")
    @GET
    public String getConfigFromSystemProperty() {
        model.put("sysApplicationName", appNameFromSysProperty);
        if (!isSystemProperty("system.application.name"))
            model.put("sysMessage", "Warning: Config is not provided via System Property!");
        model.put("isSystemProperty", isSystemProperty("system.application.name"));
        return "basic/config/sys.xhtml";
    }

    @Path("/converter")
    @GET
    public String getConverter() {
        model.put("value1", value1);
        model.put("value2", value2);
        return "basic/config/converter.xhtml";
    }

    @Path("/empty")
    @GET
    public String getEmptyValue() {
        model.put("emptyValue", emptyValue);
        return "basic/config/empty.xhtml";
    }
    @Path("/propertyclass")
    @GET
    public String getPropertyClass() {
        model.put("backendHost", backendServerConfig.getHost());
        model.put("backendPort", backendServerConfig.getPort());
        model.put("backendEndpoint", backendServerConfig.getEndpoint());

        model.put("frontendHost", frontendServerConfig.getHost());
        model.put("frontendPort", frontendServerConfig.getPort());
        model.put("frontendEndpoint", frontendServerConfig.getEndpoint());
        return "basic/config/property_class.xhtml";
    }


    public Boolean isSystemProperty(String name) {
        return System.getProperty(name) != null && !System.getProperty(name).isBlank();
    }

    public Boolean isEnvVariable(String name) {
        return System.getenv(name) != null && !System.getenv(name).isBlank() && !isSystemProperty(name);
    }


}
