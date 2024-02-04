package es.severo.ud4.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import es.severo.ud4.entity.Pelicula;
import es.severo.ud4.entity.Resenya;
import es.severo.ud4.service.PeliculaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

@RestController
@RequestMapping("/pelicula")
public class PeliculaRestController {


    private final PeliculaService peliculaService;


    public PeliculaRestController(PeliculaService peliculaService) {
        this.peliculaService = peliculaService;
    }


    @GetMapping("/peliculas")
    public List<Pelicula> getPeliculas() {
        return peliculaService.findAll();
    }

    @PostMapping
    public ResponseEntity<Pelicula> newPelicula(@RequestBody Pelicula pelicula) {
        Pelicula newPelicula = peliculaService.create(pelicula);
        return new ResponseEntity<>(newPelicula, HttpStatus.CREATED);
    }

    @GetMapping("/peliculas/hora")
    public List<Pelicula> getPeliculaMayorALaHora() {
        return peliculaService.getPeliculasMasDe1Hora();
    }

    @GetMapping("/first")
    public Pelicula getFirstOrderByTituloDesc() {
        return peliculaService.getFirstOrderTituloDesc();
    }

    private String toJson(List<Pelicula> peliculas) {
        try {
            return new ObjectMapper().writeValueAsString(peliculas);
        } catch (IOException e) {
            throw new RuntimeException("Error");
        }
    }

    @GetMapping("/json")
    public String getJson() {
        List<Pelicula> peliculas = peliculaService.findAll();
        String nombre = "pelicula.json";
        try (PrintWriter pw = new PrintWriter(nombre)) {
            pw.println(toJson(peliculas));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return "Funciona!!!";
    }





}
