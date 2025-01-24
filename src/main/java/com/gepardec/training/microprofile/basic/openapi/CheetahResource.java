package com.gepardec.training.microprofile.basic.openapi;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import java.util.List;

@Path("/cheetahs")
public interface CheetahResource {

    @Produces(MediaType.APPLICATION_JSON)
    @GET
    List<Cheetah> getCheetahs();

    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @POST
    List<Cheetah> addCheetah(Cheetah cheetah);

    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @DELETE
    Response deleteCheetah(Cheetah cheetah);

}
