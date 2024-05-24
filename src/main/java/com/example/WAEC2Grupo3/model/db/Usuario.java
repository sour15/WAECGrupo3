package com.example.WAEC2Grupo3.model.db;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Entity
@Table(name = "usuario")
@Data
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idusuario;
    private String nomusuario;
    private String email;
    private String password;
    private String nombres;
    private String apellidos;
    private Boolean activo;

    @ManyToMany(cascade = CascadeType.MERGE,fetch = FetchType.EAGER)
    @JoinTable(name = "usuario_rol",joinColumns = @JoinColumn(name = "idusuario"),
    inverseJoinColumns = @JoinColumn(name = "idrol"))
    private Set<Rol> roles;
}
