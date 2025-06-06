package com.gepardec.training.microprofile.basic.openapi;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import jdk.jfr.Description;
import org.eclipse.microprofile.openapi.annotations.Operation;
import org.eclipse.microprofile.openapi.annotations.enums.SchemaType;
import org.eclipse.microprofile.openapi.annotations.media.Content;
import org.eclipse.microprofile.openapi.annotations.media.Schema;
import org.eclipse.microprofile.openapi.annotations.parameters.Parameter;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponse;
import org.eclipse.microprofile.openapi.annotations.responses.APIResponses;

import java.util.List;

@Path("/cheetahs")
public interface CheetahResource {

    @Parameter
    @APIResponses( value = { @APIResponse( responseCode = "200", content = @Content( schema = @Schema( type = SchemaType.ARRAY, implementation = Cheetah.class))), @APIResponse( responseCode = "404", description = "Missing description" ) })
    @Operation(summary = "List full with cheetahs.")
    @Produces(MediaType.APPLICATION_JSON)
    @GET
    List<Cheetah> getCheetahs();

    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @POST
    List<Cheetah> addCheetah(Cheetah cheetah);

    @Description("Missing description")
    @APIResponses(value = { @APIResponse(responseCode = "202", description = "Operation executed successfully"), @APIResponse( name = "NoContent", responseCode = "204", description = "Missing description" )})
    @Operation( description = "Removes a cheetah from the coalition")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @DELETE
    Response deleteCheetah(Cheetah cheetah);

}
