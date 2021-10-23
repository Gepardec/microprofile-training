package com.gepardec.training.microprofile.basic.openapi;

import org.eclipse.microprofile.metrics.annotation.*;

import javax.enterprise.context.RequestScoped;
import javax.mvc.Controller;
import javax.ws.rs.GET;
import javax.ws.rs.Path;

@Path("/basic/openapi")
@RequestScoped
@Controller
@Counted(name = "counted")
@Metered(name = "metered")
@Timed(name = "timed")
@SimplyTimed(name = "simply-timed")
@ConcurrentGauge(name = "concurrent-gauge")
public class OpenAPIController {

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

    @Path("/filter")
    @GET
    public String getFilter() {
        return "basic/openapi/oasFilter.xhtml";
    }

    @Path("/staticDocument")
    @GET
    public String getStaticDocument() {
        return "basic/openapi/staticDocument.xhtml";
    }

}
