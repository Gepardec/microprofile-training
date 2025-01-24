package com.gepardec.training.microprofile.advanced.jwt;

import jakarta.enterprise.context.RequestScoped;
import jakarta.mvc.Controller;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.Response;

@RequestScoped
@Path(("/advanced/jwt/injection-proxying"))
public class InjectionProxyingController {

    /*@Inject*/
    private InjectionProxyingService injectionProxyingService;

    @Controller
    @GET
    @Path("/")
    public String get() {
        return "advanced/jwt/injection-proxying.xhtml";
    }

    @GET
    @Path("/upn")
    public Response upn_jwt() {
        if (injectionProxyingService != null && injectionProxyingService.isUpnValid()) {
            return Response.ok("\uD83E\uDD73").build();
        } else {
            return Response.status(Response.Status.BAD_REQUEST).entity("upn does not match found").build();
        }
    }
}
