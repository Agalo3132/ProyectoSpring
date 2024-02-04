package es.severo.ud4.repository;

import es.severo.ud4.entity.Resenya;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ResenyaRepository extends JpaRepository<Resenya, Long> {



    @Query("SELECT r FROM Resenya r where r.estrellas > 5")
    List<Resenya> findResenyasEstrellasMoreThanA5();

    void deleteByResenya(String text);

    @Query("SELECT r FROM Resenya r JOIN r.pelicula p WHERE p.genero = ?1")
    List<Resenya> findResenyasByGenero(String genero);

    @Query("SELECT r FROM Resenya r JOIN r.pelicula p WHERE r.estrellas >= ?1")
    List<Resenya> findResenyasByEstrellas(Long estrellas);

    @Query("SELECT r FROM Resenya r WHERE LENGTH(r.usuario.contrasenya) > 8")
    List<Resenya> findResenyasByUsuarioContrasenyaMoreThan8();

    @Query("SELECT AVG(r.estrellas) FROM Resenya r WHERE r.pelicula.titulo = :titulo")
    Double findAverageEstrellasByPeliculaTitulo(@Param("titulo") String titulo);




}
