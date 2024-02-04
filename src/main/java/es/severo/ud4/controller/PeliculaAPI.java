package es.severo.ud4.controller;

import es.severo.ud4.entity.Pelicula;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;

@Tag(name = "Pelicula API", description = "Spring application with spring-boot 3.x")

public interface PeliculaAPI {

    @Operation(
            summary = "Retrieve a list of movies",
            description = "Get all the movies that are created. The response is a list of Pelicula objects.",
            tags = {"get", "pelicula"}
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Success", content = {@Content(schema = @Schema(implementation = Pelicula.class))}),
            @ApiResponse(responseCode = "404", content = @Content(schema = @Schema()))
    })
    List<Pelicula> getTasks();
}
