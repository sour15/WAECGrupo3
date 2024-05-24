package com.example.WAEC2Grupo3.service;

import com.example.WAEC2Grupo3.model.db.Rol;
import com.example.WAEC2Grupo3.model.db.Usuario;
import com.example.WAEC2Grupo3.repository.RolRepository;
import com.example.WAEC2Grupo3.repository.UsuarioRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.HashSet;

@AllArgsConstructor
@Service
public class UsuarioService implements IUsuarioService{

    private UsuarioRepository usuarioRepository;
    private RolRepository rolRepository;

    @Override
    public Usuario obtenerUsuarioxNomUsuario(String nomusuario) {
        return usuarioRepository.findByNomusuario(nomusuario);
    }

    @Override
    public Usuario guardarUsuario(Usuario usuario, String nombreRol) {
        Rol usuarioRol = rolRepository.findByNomrol(nombreRol);
        if(usuarioRol == null) {
            usuarioRol = new Rol();
            usuarioRol.setNomrol(nombreRol);
            rolRepository.save(usuarioRol);
        }
        usuario.setRoles(new HashSet<>(Arrays.asList(usuarioRol)));
        return usuarioRepository.save(usuario);
    }

    @Override
    public void actualizarUsuario(String password, String nomusuario) {
        usuarioRepository.usuarioPasswordActualizar(password, nomusuario);
    }

}
