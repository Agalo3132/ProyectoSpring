package es.severo.ud4.service;


import es.severo.ud4.entity.Pelicula;
import es.severo.ud4.entity.Resenya;
import es.severo.ud4.repository.PeliculaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PeliculaService {


    private final PeliculaRepository peliculaRepository;


    public PeliculaService(PeliculaRepository peliculaRepository) {
        this.peliculaRepository = peliculaRepository;
    }


    public List<Pelicula> findAll() {
        return peliculaRepository.findAll();
    }

    public Pelicula create(Pelicula pelicula) {
        return peliculaRepository.save(pelicula);
    }

    public List<Pelicula> getPeliculasMasDe1Hora() {
        return peliculaRepository.encontrarPeliculasDeMasDeUnaHora();
    }

    public Pelicula getFirstOrderTituloDesc() {
        return peliculaRepository.findFirstByOrderByTituloDesc();
    }

    public Pelicula findById(Long id) {
        Optional<Pelicula> optional = peliculaRepository.findById(id);
        return optional.orElse(null);
    }

    public void delete(Long id) {
        peliculaRepository.deleteById(id);
    }



}
