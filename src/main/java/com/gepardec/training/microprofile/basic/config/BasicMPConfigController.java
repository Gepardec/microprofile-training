package com.gepardec.training.microprofile.basic.config;

import org.eclipse.microprofile.config.Config;
import org.eclipse.microprofile.config.inject.ConfigProperty;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.mvc.Controller;
import javax.mvc.Models;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import java.math.BigDecimal;


@Path("/config")
@RequestScoped
@Controller
public class BasicMPConfigController {

    @Inject
    private Models model;

    private Config config;

    @Inject
    // Do not change the default value
    @ConfigProperty(name = "file.application.name", defaultValue = "Here should be your application name")
    private String fileApplicationName;

    @Inject
    // Do not change the default value
    @ConfigProperty(name = "system.application.name", defaultValue = "Here should be your application name")
    private String systemPropertyApplicationName;

    @Inject
    // Do not change the default value
    @ConfigProperty(name = "env.application.name", defaultValue = "Here should be your application name")
    private String envApplicationName;

    @Inject
    @ConfigProperty(name = "converter.value1")
    private BigDecimal value1;

    @Inject
    @ConfigProperty(name = "converter.value2")
    private BigDecimal value2;

    @Inject
    @ConfigProperty(name = "property.empty", defaultValue = "I should be empty")
    private String emptyValue;

    private ServerConfig serverConfig = new ServerConfig();

    @Path("/file")
    @GET
    public String getConfigFromFile() {
        // TODO check not env/sysProp
        model.put("applicationName", fileApplicationName);
        return "basic/config_file.xhtml";
    }

    @Path("/env")
    @GET
    public String getConfigFromEnv() {
        model.put("envApplicationName", envApplicationName);
        model.put("isEnv", isEnvVariable("env.application.name"));
        if (!isEnvVariable("env.application.name") || (isEnvVariable("env.application.name") && isSystemProperty("env.application.name")))
            model.put("envMessage", "Warning: Config is not provided via environment variable.");
        return "basic/config_env.xhtml";
    }

    @Path("/sys")
    @GET
    public String getConfigFromSystemProperty() {
        model.put("sysApplicationName", systemPropertyApplicationName);
        if (!isSystemProperty("system.application.name"))
            model.put("sysMessage", "Warning: Config is not provided via System Property!");
        model.put("isSystemProperty", isSystemProperty("system.application.name"));
        return "basic/config_sys.xhtml";
    }

    @Path("/converter")
    @GET
    public String getConverter() {
        model.put("value1", value1);
        model.put("value2", value2);
        return "basic/config_converter.xhtml";
    }

    @Path("/empty")
    @GET
    public String getEmptyValue() {
        model.put("emptyValue", emptyValue);
        return "basic/config_empty.xhtml";
    }
    @Path("/propertyclass")
    @GET
    public String getPropertyClass() {
        model.put("host", serverConfig.getHost());
        model.put("port", serverConfig.getPort());
        model.put("endpoint", serverConfig.getEndpoint());
        return "basic/config_property_class.xhtml";
    }


    public Boolean isSystemProperty(String name) {
        return System.getProperty(name) != null && !System.getProperty(name).isBlank();
    }

    public Boolean isEnvVariable(String name) {
        return System.getenv(name) != null && !System.getenv(name).isBlank() && !isSystemProperty(name);
    }


}
