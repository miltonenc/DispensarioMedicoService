package com.mencarnacion.repository;

import com.mencarnacion.model.entities.UsuarioEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by mencarnacion on 10/07/18.
 */
@Repository
public interface UsuarioRepository extends CrudRepository<UsuarioEntity, Long> {

    @Query("Select S FROM UsuarioEntity S WHERE S.id = :id and S.estado = 1")
    @Transactional(readOnly = true)
    UsuarioEntity buscarPorId(@Param("id") Long id);

    @Query("Select S FROM UsuarioEntity S WHERE UPPER(S.usuario) = UPPER(:usuario) and UPPER(S.password) = UPPER(:password) " +
            "and S.estado = 1")
    @Transactional(readOnly = true)
    UsuarioEntity login(@Param("usuario") String usuario, @Param("password") String password);

    @Query("Select S FROM UsuarioEntity S WHERE S.estado = 1 order by S.usuario asc")
    @Transactional(readOnly = true)
    List<UsuarioEntity> obtenerListado();

    @Query("Select S FROM UsuarioEntity S WHERE UPPER(S.usuario) = UPPER(:usuario) and S.estado = 1 order by S.usuario asc")
    @Transactional(readOnly = true)
    List<UsuarioEntity> obtenerListadoByUsuario(@Param("usuario") String usuario);


    @Query("Select CASE WHEN (COUNT(S.id) > 0) THEN true  ELSE false END " +
            " FROM UsuarioEntity S WHERE UPPER(S.usuario) = UPPER(:pUsuario) AND S.estado = 1 ")
    @Transactional(readOnly = true)
    boolean isExisteUsuario(@Param("pUsuario") String pUsuario);
}
