package com.gepardec.training.microprofile.basic.config;

import com.gepardec.training.microprofile.SystemHelper;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.mvc.Controller;
import javax.mvc.Models;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/basic/config/sys")
@RequestScoped
public class SystemPropertyController {

    @Inject
    private SystemHelper systemHelper;

    @Inject
    private Models model;

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
