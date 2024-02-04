package es.severo.ud4.repository;

import es.severo.ud4.entity.Pelicula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PeliculaRepository extends JpaRepository<Pelicula, Long> {

    @Query("SELECT t FROM Pelicula t where t.duracion > 60")
    List<Pelicula> encontrarPeliculasDeMasDeUnaHora();

    Pelicula findFirstByOrderByTituloDesc();



}
