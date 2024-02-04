package es.severo.ud4.controller;

import es.severo.ud4.entity.Pelicula;
import es.severo.ud4.entity.Resenya;
import es.severo.ud4.service.PeliculaService;
import es.severo.ud4.service.ResenyaService;
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

    @GetMapping("/resenyas")
    public List<Resenya> getTasks() {
        return resenyaService.findAll();
    }

    @PostMapping
    public ResponseEntity<Resenya> newResenya(@RequestBody Resenya resenya) {
        Resenya newResenya = resenyaService.create(resenya);
        return new ResponseEntity<>(newResenya, HttpStatus.CREATED);
    }

    @GetMapping("/estrellas/mayor")
    public List<Resenya> getResenyasMayoresA5() {
        return resenyaService.getResenyasMayoresA5();
    }

    @PatchMapping("/patch")
    public ResponseEntity<Resenya> update(@RequestBody Resenya resenya) {
        try {
            Resenya resenyaUpdated = resenyaService.actualizarResenya(resenya);
            return new ResponseEntity<>(resenyaUpdated, HttpStatus.OK);
        } catch (RuntimeException e) {
            return new ResponseEntity<>(resenya, HttpStatus.NOT_MODIFIED);
        }
    }

    @PutMapping("/put/{id}")
    public Resenya change(@RequestBody Resenya resenya) {
        return resenyaService.cambiarResenya(resenya);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long id) {
        resenyaService.delete(id);
        return new ResponseEntity<>("The task was deleted", HttpStatus.OK);
    }

    @GetMapping("/r")
    public List<Resenya> getResenyas(@RequestParam(defaultValue = "1") Integer pageNo,
                               @RequestParam(defaultValue = "3") Integer pageSize,
                               @RequestParam(required = false, defaultValue = "resenya") String sortBy,
                               @RequestParam(defaultValue = "ASC") Sort.Direction sortOrder) {
        return resenyaService.findAllPageabled(pageNo-1, pageSize, sortBy, sortOrder);
    }

    @DeleteMapping("/delete/{resenya}")
    public ResponseEntity<String> deleteByResenya(@PathVariable("resenya") String texto) {
        resenyaService.deleteResenyaByResenya(texto);
        return new ResponseEntity<>("The review was deleted", HttpStatus.OK);
    }

    @GetMapping("/find/{genero}")
    public List<Resenya> getResenyaByGenero(@PathVariable("genero") String genero) {
        return resenyaService.getResenyasByGenero(genero);
    }

    @GetMapping("/find/estrellas/{estrellas}")
    public List<Resenya> getResenyaByEstrellas(@PathVariable("estrellas") Long estrellas) {
        return resenyaService.getResenyasByEstrellas(estrellas);
    }

    @GetMapping("/find/user/password")
    public List<Resenya> getResenyaWithUserPasswordMoreThan8() {
        return resenyaService.getResenyasWithUserPassMoreThan8();
    }

    @GetMapping("/find/estrellas/promedio")
    public Double getAverageEstrellasByPeliculaTitulo(String titulo) {
        return resenyaService.getAverageEstrellasByPeliculaTitulo(titulo);
    }

}
