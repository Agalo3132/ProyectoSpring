package es.severo.ud4.controller;

import es.severo.ud4.entity.Director;
import es.severo.ud4.entity.Pelicula;
import es.severo.ud4.service.DirectorService;
import es.severo.ud4.service.PeliculaService;
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


    @GetMapping("/directores")
    public List<Director> getDirectores() {
        return directorService.findAll();
    }

    @PostMapping("/add")
    public Director newDirectorOG(@RequestBody Director director) {
        return directorService.create(director);
    }

    @PostMapping
    public ResponseEntity<Director> newDirector(@RequestBody Director director) {
        Director newDirector = directorService.create(director);
        return new ResponseEntity<>(newDirector, HttpStatus.CREATED);
    }

    @PatchMapping("/update")
    public ResponseEntity<Director> update(@RequestBody Director director) {
        try {
            Director directorUpdated = directorService.actualizarDirector(director);
            return new ResponseEntity<>(directorUpdated, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(director, HttpStatus.NOT_MODIFIED);
        }
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long id) {
        directorService.delete(id);
        return new ResponseEntity<>("The director was deleted", HttpStatus.OK);
    }

    @GetMapping("/find/{apellido1}")
    public Director getDirectorByApellido1(@PathVariable("apellido1") String apellido1) {
        return directorService.getByApellido1(apellido1);
    }

}
