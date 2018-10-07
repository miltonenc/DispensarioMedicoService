package com.mencarnacion.repository;

import com.mencarnacion.model.entities.UsuarioRolEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by mencarnacion on 8/30/18.
 */
@Repository
public interface UsuarioRolRepository extends CrudRepository<UsuarioRolEntity, Long> {

    @Query("Select S FROM UsuarioRolEntity S WHERE S.id = :id and S.estado = 1")
    @Transactional(readOnly = true)
    UsuarioRolEntity buscarPorId(@Param("id") Long id);

    @Query("Select S FROM UsuarioRolEntity S WHERE S.estado = 1 order by S.usuario.usuario asc")
    @Transactional(readOnly = true)
    List<UsuarioRolEntity> obtenerListado();

    @Query("Select S FROM UsuarioRolEntity S WHERE S.estado = 1 and S.usuario.id = :usuarioId order by S.usuario.usuario asc")
    @Transactional(readOnly = true)
    List<UsuarioRolEntity> obtenerListadoPorUsuarioId(@Param("usuarioId") Long usuarioId);
}
