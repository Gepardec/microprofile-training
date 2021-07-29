package com.gepardec.training.microprofile.basic.openapi;

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
    @Parameter
    @GET
    @APIResponses(
            value = {
                    @APIResponse(responseCode = "404",
                            description = "Missing description",
                            content = @Content(mediaType = "text/plain")),
                    @APIResponse(
                            responseCode = "200",
                            content = @Content(
                                    mediaType = "application/json",
                                    schema = @Schema(
                                            type = SchemaType.OBJECT,
                                            implementation = Cheetah.class)))})
    @Operation(summary = "List full with cheetahs.")
    public Response list() {
        return Response.ok(cheetahs).build();
    }


    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @APIResponse(
            responseCode = "201",
            description = "Cheetah created"
    )
    @POST
    public Set<Cheetah> add(Cheetah cheetah) {
        cheetahs.add(cheetah);
        return cheetahs;
    }

    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Description("Missing description")
    @Operation(
            description = "Removes a cheetah from the coalition")
    @APIResponses(value = {
            @APIResponse(responseCode = "202",
                    description = "Operation executed successfully"),

            @APIResponse(
                    name = "NoContent",
                    responseCode = "204",
                    description = "Missing description"
            )})
    @DELETE
    public Response delete(Cheetah cheetah) {
        if (cheetah == null) {
            return Response.noContent().build();
        }

        cheetahs.removeIf(existingCheetah -> existingCheetah.getName().equalsIgnoreCase(cheetah.getName()));
        return Response.accepted(cheetahs).build();
    }

}
