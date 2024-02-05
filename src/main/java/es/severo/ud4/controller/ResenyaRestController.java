package es.severo.ud4.controller;

import es.severo.ud4.entity.Pelicula;
import es.severo.ud4.entity.Resenya;
import es.severo.ud4.service.PeliculaService;
import es.severo.ud4.service.ResenyaService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/resenya")
public class ResenyaRestController {

    private final ResenyaService resenyaService;


    public ResenyaRestController(ResenyaService resenyaService) {
        this.resenyaService = resenyaService;
    }

    @Operation(summary = "Devuelve todas las resenyas existentes")
    @GetMapping("/resenyas")
    public List<Resenya> getTasks() {
        return resenyaService.findAll();
    }

    @Operation(summary = "Crea una resenya nueva")
    @PostMapping
    public ResponseEntity<Resenya> newResenya(@RequestBody Resenya resenya) {
        Resenya newResenya = resenyaService.create(resenya);
        return new ResponseEntity<>(newResenya, HttpStatus.CREATED);
    }

    @Operation(summary = "Devuelve resenyas con mas de 5 estrellas existente")
    @GetMapping("/estrellas/mayor")
    public List<Resenya> getResenyasMayoresA5() {
        return resenyaService.getResenyasMayoresA5();
    }

    @Operation(summary = "Actualiza una resenyas existente")
    @PatchMapping("/patch")
    public ResponseEntity<Resenya> update(@RequestBody Resenya resenya) {
        try {
            Resenya resenyaUpdated = resenyaService.actualizarResenya(resenya);
            return new ResponseEntity<>(resenyaUpdated, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(resenya, HttpStatus.NOT_MODIFIED);
        }
    }

    @Operation(summary = "Cambia una resenya existente")
    @PutMapping("/put/{id}")
    public Resenya change(@RequestBody Resenya resenya) {
        return resenyaService.cambiarResenya(resenya);
    }

    @Operation(summary = "Borra una resenya existente")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long id) {
        resenyaService.delete(id);
        return new ResponseEntity<>("The task was deleted", HttpStatus.OK);
    }

    @Operation(summary = "Devuelve las resenyas por paginas")
    @GetMapping("/r")
    public List<Resenya> getResenyas(@RequestParam(defaultValue = "1") Integer pageNo,
                               @RequestParam(defaultValue = "3") Integer pageSize,
                               @RequestParam(required = false, defaultValue = "resenya") String sortBy,
                               @RequestParam(defaultValue = "ASC") Sort.Direction sortOrder) {
        return resenyaService.findAllPageabled(pageNo-1, pageSize, sortBy, sortOrder);
    }

    @Operation(summary = "Borra una resenya existente")
    @DeleteMapping("/delete/{resenya}")
    public ResponseEntity<String> deleteByResenya(@PathVariable("resenya") String texto) {
        resenyaService.deleteResenyaByResenya(texto);
        return new ResponseEntity<>("The review was deleted", HttpStatus.OK);
    }

    @Operation(summary = "Busca una resenya existente")
    @GetMapping("/find/{genero}")
    public List<Resenya> getResenyaByGenero(@PathVariable("genero") String genero) {
        return resenyaService.getResenyasByGenero(genero);
    }

    @Operation(summary = "Busca resenyas existentes por las estrellas")
    @GetMapping("/find/estrellas/{estrellas}")
    public List<Resenya> getResenyaByEstrellas(@PathVariable("estrellas") Long estrellas) {
        return resenyaService.getResenyasByEstrellas(estrellas);
    }

    @Operation(summary = "Busca resenya hechas por usuarios con contrsaseñas mayores a 8 caracteres")
    @GetMapping("/find/user/password")
    public List<Resenya> getResenyaWithUserPasswordMoreThan8() {
        return resenyaService.getResenyasWithUserPassMoreThan8();
    }

    @Operation(summary = "Devuelve el promedio de estrellas de una pelicula por el titulo")
    @GetMapping("/find/estrellas/promedio")
    public Double getAverageEstrellasByPeliculaTitulo(String titulo) {
        return resenyaService.getAverageEstrellasByPeliculaTitulo(titulo);
    }

}
