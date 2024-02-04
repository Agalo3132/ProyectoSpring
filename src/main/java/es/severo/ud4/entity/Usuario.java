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
@Table(name = "usuario")
@Entity
public class Usuario {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long email;

    @Column(nullable = false)
    private String nombre;

    private String apellido1;

    private String apellido2;

    @Column(nullable = false)
    private String contrasenya;

}
