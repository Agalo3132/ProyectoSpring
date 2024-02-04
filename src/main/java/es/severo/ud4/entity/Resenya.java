package es.severo.ud4.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@ToString
@Setter
@Getter
@Table(name = "resenya")
@Entity
public class Resenya {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String resenya;

    @Column(nullable = false)
    private Long estrellas;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "pelicula_id")
    private Pelicula pelicula;

    @OneToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "usuario_id")
    private Usuario usuario;

}
