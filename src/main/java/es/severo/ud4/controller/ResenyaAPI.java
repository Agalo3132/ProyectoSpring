package es.severo.ud4.controller;

import es.severo.ud4.entity.Pelicula;
import es.severo.ud4.entity.Resenya;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;

import java.util.List;

@Tag(name = "Reseña API", description = "Spring application with spring-boot 3.x")

public interface ResenyaAPI {

    @Operation(
            summary = "Retrieve a list of reseñas",
            description = "Get all the reviews that are created. The response is a list of Reseñas objects.",
            tags = {"get", "resenya"}
    )
    @ApiResponses({
            @ApiResponse(responseCode = "200", description = "Success", content = {@Content(schema = @Schema(implementation = Resenya.class))}),
            @ApiResponse(responseCode = "404", content = @Content(schema = @Schema()))
    })
    List<Pelicula> getTasks();
}

