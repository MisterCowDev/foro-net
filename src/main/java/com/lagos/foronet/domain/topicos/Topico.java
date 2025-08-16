package com.lagos.foronet.domain.topicos;

import jakarta.persistence.*;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Table(name = "topicos",
uniqueConstraints = @UniqueConstraint(columnNames = {"titulo", "mensaje"}))
@Entity(name = "Topico")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Topico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String titulo;
    private String mensaje;

    @Column(name = "fecha_creacion")
    private LocalDateTime fechaCreacion;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private Estado estado;

    private String autor;
    private String curso;

    public void updateDatos(@Valid DatosActualizarTopico datosActualizarTopico) {
        if (datosActualizarTopico.autor() != null){
            this.autor = datosActualizarTopico.autor();
        }
        if (datosActualizarTopico.titulo() != null){
            this.titulo = datosActualizarTopico.titulo();
        }
        if (datosActualizarTopico.mensaje() != null){
            this.mensaje = datosActualizarTopico.mensaje();
        }
        if (datosActualizarTopico.curso() != null){
            this.curso = datosActualizarTopico.curso();
        }
    }

    public void desactivarTopico() {
        this.estado = Estado.INACTIVO;
    }
}
