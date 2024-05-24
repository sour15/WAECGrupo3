package com.example.WAEC2Grupo3.service;

import com.example.WAEC2Grupo3.model.db.Usuario;

public interface IUsuarioService {
    Usuario obtenerUsuarioxNomUsuario(String nomusuario);
    Usuario guardarUsuario (Usuario usuario, String nombreRol);
    void actualizarUsuario(String password, String nomusuario);
}
