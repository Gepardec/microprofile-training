package com.gepardec.training.microprofile.basic.openapi;

<<<<<<< Updated upstream
=======
import jdk.jfr.Description;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.enums.SchemaType;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.parameters.Parameter;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;

>>>>>>> Stashed changes
import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
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
