package es.severo.ud4.repository;

import es.severo.ud4.entity.Director;
import es.severo.ud4.entity.Pelicula;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DirectorRepository extends JpaRepository<Director, Long> {


    @Query(value = "SELECT * FROM Director WHERE apellido1 LIKE %?1%", nativeQuery = true)
    Director buscaPorApellido1(String apellido1);

}
