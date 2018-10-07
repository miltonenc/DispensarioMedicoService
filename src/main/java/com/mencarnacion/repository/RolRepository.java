package com.mencarnacion.repository;

import com.mencarnacion.model.entities.RolEntity;
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
public interface RolRepository extends CrudRepository<RolEntity, Long> {

    @Query("Select S FROM RolEntity S WHERE S.id = :id")
    @Transactional(readOnly = true)
    RolEntity buscarPorId(@Param("id") Long id);

    @Query("Select S FROM RolEntity S")
    @Transactional(readOnly = true)
    List<RolEntity> obtenerListado();
}
