package com.example.WAEC2Grupo3.model.db;

import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Entity
@Data
@Table(name = "rol")
public class Rol {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idrol;
    private String nomrol;
    @OneToMany(mappedBy = "rol")
    private List<ProgramaTv> list;
}
