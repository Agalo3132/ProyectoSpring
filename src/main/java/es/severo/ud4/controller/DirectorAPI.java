package es.severo.ud4.controller;

import es.severo.ud4.entity.Director;
import es.severo.ud4.entity.Pelicula;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;

@Tag(name = "Director API", description = "Spring application with spring-boot 3.x")

public interface DirectorAPI {


    @Operation(
            summary = "Retrieve a list of directors",
            description = "Get all the directors that are created. The response is a list of Director objects.",
            tags = {"get", "director"}
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Success", content = {@Content(schema = @Schema(implementation = Director.class))}),
            @ApiResponse(responseCode = "404", content = @Content(schema = @Schema()))
    })
    List<Pelicula> getTasks();
}
