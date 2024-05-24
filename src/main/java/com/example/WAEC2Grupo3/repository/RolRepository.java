package com.example.WAEC2Grupo3.repository;

import com.example.WAEC2Grupo3.model.db.Rol;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface RolRepository extends JpaRepository<Rol, Integer> {
    Rol findByNomrol(String nomrol);

    @Query(value = "INSERT INTO rol (nomrol) VALUES (:nomrol)", nativeQuery = true)
    void guardarRolXNombre(String nomrol);
}
