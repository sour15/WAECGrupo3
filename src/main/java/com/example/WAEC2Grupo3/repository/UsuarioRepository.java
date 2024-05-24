package com.example.WAEC2Grupo3.repository;

import com.example.WAEC2Grupo3.model.db.Usuario;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {
    Usuario findByNomusuario(String nomusuario);

    @Transactional
    @Modifying
    @Query(value = "UPDATE usuario SET password=:password WHERE nomusuario=:nomusuario", nativeQuery = true)
    void usuarioPasswordActualizar(@Param("password") String password,
                    @Param("nomusuario") String nomusuario);
}
