package com.gepardec.training.microprofile.basic.openapi;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.mvc.Controller;
import javax.mvc.Models;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/basic/openapi")
@RequestScoped
@Controller
public class OpenAPIController {

    @Inject
    private Models model;

    @Path("/")
    @GET
    public String get() {
        return index();
    }

    @Path("/index")
    @GET
    public String index() {
        return "basic/openapi/index.xhtml";
    }

    @Path("/document")
    @GET
    public String getDocument() {
        return "basic/openapi/document.xhtml";
    }

    @Path("/annotations")
    @GET
    public String getAnnotations() {
        return "basic/openapi/annotations.xhtml";
    }


}
