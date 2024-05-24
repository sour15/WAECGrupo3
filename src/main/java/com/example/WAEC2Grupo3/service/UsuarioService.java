package com.example.WAEC2Grupo3.service;

import com.example.WAEC2Grupo3.model.db.Usuario;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class UsuarioService implements IUsuarioService{
    @Override
    public Usuario obtenerUsuarioxNomUsuario(String nomusuario) {
        return null;
    }

    @Override
    public Usuario guardarUsuario(Usuario usuario, String nombreRol) {
        return null;
    }

    @Override
    public void actualizarUsuario(String password, String nomusuario) {

    }
}
