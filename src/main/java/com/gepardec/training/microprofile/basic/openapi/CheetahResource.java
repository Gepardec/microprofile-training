package com.gepardec.training.microprofile.basic.openapi;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Set;

@Path("/cheetahs")
public class CheetahResource {

    private Set<Cheetah> cheetahs = Collections.newSetFromMap(Collections.synchronizedMap(new LinkedHashMap<>()));

    public CheetahResource() {
        cheetahs.add(new Cheetah(1, "Nala", 30.4));
        cheetahs.add(new Cheetah(6, "Simba", 54.6));
    }

    @Produces(MediaType.APPLICATION_JSON)
    @GET
    public Set<Cheetah> list() {
        if (cheetahs.isEmpty())
            Response.status(Response.Status.NOT_FOUND).entity("No cheetahs found").build();
        return cheetahs;
    }

    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @POST
    public Set<Cheetah> add(Cheetah cheetah) {
        cheetahs.add(cheetah);
        return cheetahs;
    }

    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @DELETE
    public Response delete(Cheetah cheetah) {
        if (cheetah == null) {
            return Response.noContent().build();
        }

        cheetahs.removeIf(existingCheetah -> existingCheetah.getName().equalsIgnoreCase(cheetah.getName()));
        return Response.accepted(cheetahs).build();
    }

}
