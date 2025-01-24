package com.gepardec.training.microprofile.basic.openapi;

import org.eclipse.microprofile.metrics.annotation.*;

import jakarta.enterprise.context.RequestScoped;
import jakarta.mvc.Controller;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("/basic/openapi")
@RequestScoped
@Controller
@Counted(name = "counted")
//TODO: fix @Metered(name = "metered")
@Timed(name = "timed")
//TODO: fix @SimplyTimed(name = "simply-timed")
//TODO: fix @ConcurrentGauge(name = "concurrent-gauge")
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
