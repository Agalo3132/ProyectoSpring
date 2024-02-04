package es.severo.ud4.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@NoArgsConstructor
@ToString
@Setter
@Getter
@Table(name = "pelicula")
@Entity
public class Pelicula {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String titulo;

    @Column(nullable = false)
    private String genero;

    @Column(nullable = false)
    private Long duracion;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "director_id")
    //@OnDelete(action = OnDeleteAction.CASCADE)
    private Director director;


}
