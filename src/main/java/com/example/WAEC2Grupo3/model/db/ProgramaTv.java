package com.example.WAEC2Grupo3.model.db;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name ="programatv" )
@Data
public class ProgramaTv {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idprogramatv;
    private String titulo;
    private LocalDate fechainicio;
    private Integer idpersonaje;

    @ManyToOne
    @JoinColumn(name = "idpersonaje", insertable = false,updatable = false)
    private Personaje personaje;
}
