package com.example.WAEC2Grupo3.model.db;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

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

    @JsonIgnore
    @OneToMany(mappedBy = "personaje")
    private List<ProgramaTv> list;
}
