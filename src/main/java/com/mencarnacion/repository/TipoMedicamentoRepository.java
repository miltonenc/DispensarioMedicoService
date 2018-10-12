package com.mencarnacion.repository;

import com.mencarnacion.model.entities.TipoMedicamentoEntity;
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
public interface TipoMedicamentoRepository extends CrudRepository<TipoMedicamentoEntity, Long> {

    @Query("Select S FROM TipoMedicamentoEntity S WHERE S.id = :id and S.estado = 1")
    @Transactional(readOnly = true)
    TipoMedicamentoEntity buscarPorId(@Param("id") Long id);

    @Query("Select S FROM TipoMedicamentoEntity S WHERE S.estado = 1 order by S.nombre asc")
    @Transactional(readOnly = true)
    List<TipoMedicamentoEntity> obtenerListado();


    @Query("select CASE WHEN (COUNT(S.id) > 0) THEN true  ELSE false END " +
            " FROM TipoMedicamentoEntity S WHERE UPPER(S.nombre) = UPPER(:pNombre)" +
            " AND S.id != :pId AND S.estado = 1 ")
    @Transactional(readOnly = true)
    boolean isExisteRegistroPorId(@Param("pNombre") String pNombre, @Param("pId") Long pId);


    @Query("Select CASE WHEN (COUNT(S.id) > 0) THEN true  ELSE false END " +
            " FROM TipoMedicamentoEntity S WHERE UPPER(S.nombre) = UPPER(:pNombre) AND S.estado = 1 ")
    @Transactional(readOnly = true)
    boolean isExisteRegistro(@Param("pNombre") String pNombre);
}
