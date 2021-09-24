package com.gepardec.training.microprofile.basic.jwt;

import javax.enterprise.context.RequestScoped;
import javax.mvc.Controller;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.core.Response;

@RequestScoped
@Path(("/basic/jwt/injection"))
public class InjectionController {

    String upn;

    @Controller
    @GET
    @Path("/")
    public String get() {
        return "basic/jwt/injection.xhtml";
    }

    @GET
    @Path("/upn-jwt")
    public Response upn_jwt() {
        if (getUpnFromJwt() != null) {
            return Response.ok(getUpnFromJwt()).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).entity("upn not found").build();
        }
    }

    private String getUpnFromJwt() {
        return null;
    }

    @GET
    @Path("/upn-claim")
    public Response upn_claim() {
        if (upn != null) {
            return Response.ok(upn).build();
        } else {
            return Response.status(Response.Status.NOT_FOUND).entity("upn not found").build();
        }
    }
}
