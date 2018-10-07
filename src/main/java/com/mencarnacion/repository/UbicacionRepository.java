package com.mencarnacion.repository;

import com.mencarnacion.model.entities.UbicacionEntity;
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
public interface UbicacionRepository extends CrudRepository<UbicacionEntity, Long> {

    @Query("Select S FROM UbicacionEntity S WHERE S.id = :id and S.estado = 1")
    @Transactional(readOnly = true)
    UbicacionEntity buscarPorId(@Param("id") Long id);

    @Query("Select S FROM UbicacionEntity S WHERE S.codigo = :pCodigo and S.estado = 1")
    @Transactional(readOnly = true)
    UbicacionEntity buscarPorCodigo(@Param("pCodigo") String pCodigo);

    @Query("Select S FROM UbicacionEntity S WHERE S.estado = 1 order by S.codigo asc")
    @Transactional(readOnly = true)
    List<UbicacionEntity> obtenerListado();
}
