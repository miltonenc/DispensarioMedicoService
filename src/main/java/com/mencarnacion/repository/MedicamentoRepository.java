package com.mencarnacion.repository;

import com.mencarnacion.model.entities.MedicamentoEntity;
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
public interface MedicamentoRepository extends CrudRepository<MedicamentoEntity, Long> {

    @Query("Select S FROM MedicamentoEntity S WHERE S.id = :id and S.estado = 1")
    @Transactional(readOnly = true)
    MedicamentoEntity buscarPorId(@Param("id") Long id);


    @Query("Select S FROM MedicamentoEntity S WHERE S.estado = 1 order by S.nombre asc")
    @Transactional(readOnly = true)
    List<MedicamentoEntity> obtenerListado();


    @Query("select CASE WHEN (COUNT(S.id) > 0) THEN true  ELSE false END " +
            " FROM MedicamentoEntity S WHERE UPPER(S.nombre) = UPPER(:pNombre)" +
            " AND S.id != :pId AND S.fabricante.id = :pFabricanteId AND S.estado = 1 ")
    @Transactional(readOnly = true)
    boolean isExisteRegistroPorId(@Param("pNombre") String pNombre, @Param("pId") Long pId,
                                  @Param("pFabricanteId") Long pFabricanteId);


    @Query("Select CASE WHEN (COUNT(S.id) > 0) THEN true  ELSE false END " +
            " FROM MedicamentoEntity S WHERE UPPER(S.nombre) = UPPER(:pNombre) AND S.fabricante.id = :pFabricanteId " +
            " AND S.estado = 1 ")
    @Transactional(readOnly = true)
    boolean isExisteRegistro(@Param("pNombre") String pNombre, @Param("pFabricanteId") Long pFabricanteId);
}
