package es.severo.ud4.controller;

import es.severo.ud4.entity.Director;
import es.severo.ud4.entity.Pelicula;
import es.severo.ud4.entity.Resenya;
import es.severo.ud4.service.DirectorService;
import es.severo.ud4.service.PeliculaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/director")
public class DirectorRestController {

    private final DirectorService directorService;

    public DirectorRestController(DirectorService directorService) {
        this.directorService = directorService;
    }


    @Operation(summary = "Devuelve todos los directores existente")
    @GetMapping("/directores")
    public List<Director> getDirectores() {
        return directorService.findAll();
    }

    @Operation(summary = "Crea un nuevo director")
    @PostMapping("/add")
    public Director newDirectorOG(@RequestBody Director director) {
        return directorService.create(director);
    }

    @Operation(summary = "Crea un nuevo director")
    @PostMapping("/create")
    public ResponseEntity<Director> newDirector(@RequestBody Director director) {
        Director newDirector = directorService.create(director);
        return new ResponseEntity<>(newDirector, HttpStatus.CREATED);
    }

    @Operation(summary = "Actualiza un director existente")
    @PatchMapping("/update")
    public ResponseEntity<Director> update(@RequestBody Director director) {
        try {
            Director directorUpdated = directorService.actualizarDirector(director);
            return new ResponseEntity<>(directorUpdated, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(director, HttpStatus.NOT_MODIFIED);
        }
    }

    @Operation(summary = "Borrar un director por su id")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long id) {
        directorService.delete(id);
        return new ResponseEntity<>("The director was deleted", HttpStatus.OK);
    }

    @Operation(summary = "Encontrar un director por su primer apellido")
    @GetMapping("/find/{apellido1}")
    public Director getDirectorByApellido1(@PathVariable("apellido1") String apellido1) {
        return directorService.getByApellido1(apellido1);
    }

    @Operation(summary = "Cambiar un director existente")
    @PutMapping("/put/{dni}")
    public Director change(@RequestBody Director director) {
        return directorService.cambiarDirector(director);
    }

}
