package es.severo.ud4.service;

import es.severo.ud4.entity.Resenya;
import es.severo.ud4.repository.ResenyaRepository;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ResenyaService {

    private final ResenyaRepository resenyaRepository;


    public ResenyaService(ResenyaRepository resenyaRepository) {
        this.resenyaRepository = resenyaRepository;
    }


    public List<Resenya> findAll() {
        return resenyaRepository.findAll();
    }

    public Resenya create(Resenya resenya) {
        return resenyaRepository.save(resenya);
    }

    public List<Resenya> getResenyasMayoresA5() {
        return resenyaRepository.findResenyasEstrellasMoreThanA5();
    }

    public Resenya findById(Long id) {
        Optional<Resenya> optional = resenyaRepository.findById(id);
        return optional.orElse(null);
    }

    public void delete(Long id) {
        resenyaRepository.deleteById(id);
    }

    public Resenya actualizarResenya(Resenya resenya) {
        if (resenya.getId() != null) {
            return resenyaRepository.save(resenya);
        }
        throw new RuntimeException("MAl");
    }

    public Resenya cambiarResenya(Resenya resenya) {
        return resenyaRepository.save(resenya);
    }

    public List<Resenya> findAllPageabled(Integer pageNo, Integer pageSize, String sortBy, Sort.Direction orderBy) {
        Pageable pageable = PageRequest.of(pageNo, pageSize, Sort.by(orderBy, sortBy));

        return resenyaRepository.findAll(pageable).getContent();
    }

    @Transactional
    public void deleteResenyaByResenya(String text) {
        resenyaRepository.deleteByResenya(text);
    }

    public List<Resenya> getResenyasByGenero(String genero) {
        return resenyaRepository.findResenyasByGenero(genero);
    }

    public List<Resenya> getResenyasByEstrellas(Long estrellas) {
        return resenyaRepository.findResenyasByEstrellas(estrellas);
    }

    public List<Resenya> getResenyasWithUserPassMoreThan8() {
        return resenyaRepository.findResenyasByUsuarioContrasenyaMoreThan8();
    }

    public Double getAverageEstrellasByPeliculaTitulo(String titulo) {
        return resenyaRepository.findAverageEstrellasByPeliculaTitulo(titulo);
    }

}
