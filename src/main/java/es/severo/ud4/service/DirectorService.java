package es.severo.ud4.service;

import es.severo.ud4.entity.Director;
import es.severo.ud4.entity.Pelicula;
import es.severo.ud4.repository.DirectorRepository;
import es.severo.ud4.repository.PeliculaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DirectorService {

    private final DirectorRepository directorRepository;


    public DirectorService(DirectorRepository directorRepository) {
        this.directorRepository = directorRepository;
    }

    public List<Director> findAll() {
        return directorRepository.findAll();
    }

    public Director create(Director director) {
        return directorRepository.save(director);
    }

    public Director actualizarDirector(Director director) {
        if (director.getDni() != null) {
            return directorRepository.save(director);
        }
        throw new RuntimeException("The field dni is mandatory" );
    }

    public void delete(Long id) {
        directorRepository.deleteById(id);
    }

    public Director getByApellido1(String title) {
        return directorRepository.buscaPorApellido1(title);
    }

    public Director findById(Long id) {
        Optional<Director> optional = directorRepository.findById(id);
        return optional.orElse(null);
    }

}
