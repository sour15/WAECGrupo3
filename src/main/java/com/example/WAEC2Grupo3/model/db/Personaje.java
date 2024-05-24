package com.example.WAEC2Grupo3.model.db;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Entity
@Table(name = "personaje")
@Data
public class Personaje {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idpersonaje;
    private String nompersonaje;
    private String apepersonaje;
    private LocalDate fechnacpersonaje;

}
