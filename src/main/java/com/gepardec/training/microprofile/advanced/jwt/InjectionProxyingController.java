package com.gepardec.training.microprofile.advanced.jwt;

import javax.enterprise.context.RequestScoped;
import javax.mvc.Controller;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

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
