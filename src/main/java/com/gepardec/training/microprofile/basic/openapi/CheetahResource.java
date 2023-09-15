package com.gepardec.training.microprofile.basic.openapi;

import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jdk.jfr.Description;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.enums.SchemaType;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.parameters.Parameter;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

@Path("/cheetahs")
public interface CheetahResource {

    @Parameter
    @APIResponses(value = {
            @APIResponse(responseCode = "200", content = @Content(schema = @Schema(type = SchemaType.ARRAY, implementation = Cheetah.class))),
            @APIResponse(responseCode = "404", description = "Missing description")
    })
    @Operation(summary = "List full with cheetahs.")
    @Produces(MediaType.APPLICATION_JSON)
    @GET
    List<Cheetah> getCheetahs();

    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @POST
    List<Cheetah> addCheetah(Cheetah cheetah);

    @Description("Missing description")
    @Operation(description = "Removes a cheetah from the coalition")
    @APIResponses(value = {
            @APIResponse(responseCode = "202", description = "Operation executed successfully"),
            @APIResponse(name = "NoContent", responseCode = "204", description = "Missing description")
    })
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @DELETE
    Response deleteCheetah(Cheetah cheetah);

}
