package com.gepardec.training.microprofile.basic.config;

import com.gepardec.training.microprofile.SystemHelper;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.mvc.Controller;
import javax.mvc.Models;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/basic/config/file")
@RequestScoped
public class FileController {

    @Inject
    private SystemHelper systemHelper;

    @Inject
    private Models model;

    private String appName;

    @Path("/")
    @GET
    @Controller
    public String getConfigFromPropertyFile() {
        model.put("applicationName", appName);
        if (systemHelper.isEnvVariable("file.application.name")) {
            model.put("fileMessage", "Warning: Config is provided via a env variable and not via microprofile-properties.properties.");
        } else if (systemHelper.isSystemProperty("file.application.name")) {
            model.put("fileMessage", "Warning: Config is provided via system property and not via microprofile-properties.properties.");
        } else if (appName == null) {
            model.put("fileMessage", "Warning: Config is not provided via microprofile-properties.properties.");
        }
        return "basic/config/file.xhtml";
    }
}
