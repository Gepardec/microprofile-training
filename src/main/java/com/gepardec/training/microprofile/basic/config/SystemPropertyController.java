package com.gepardec.training.microprofile.basic.config;

import com.gepardec.training.microprofile.SystemHelper;

import jakarta.enterprise.context.RequestScoped;
import jakarta.inject.Inject;
import jakarta.mvc.Controller;
import jakarta.mvc.Models;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import org.eclipse.microprofile.config.inject.ConfigProperty;

@Path("/basic/config/sys")
@RequestScoped
public class SystemPropertyController {

    @Inject
    private SystemHelper systemHelper;

    @Inject
    private Models model;

    @Inject
    @ConfigProperty(name = "system.application.name")
    private String appName;

    @Path("/")
    @GET
    @Controller
    public String getConfigFromSystemProperty() {
        model.put("sysApplicationName", appName);
        if (!systemHelper.isSystemProperty("system.application.name"))
            model.put("sysMessage", "Warning: Config is not provided via System Property!");
        model.put("isSystemProperty", systemHelper.isSystemProperty("system.application.name"));
        return "basic/config/sys.xhtml";
    }
}
