package com.mencarnacion.repository;

import com.mencarnacion.model.entities.PersonaEntity;
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
public interface PersonaRepository extends CrudRepository<PersonaEntity, Long> {

    @Query("Select S FROM PersonaEntity S WHERE S.id = :id and S.estado = 1")
    @Transactional(readOnly = true)
    PersonaEntity buscarPorId(@Param("id") Long id);

    @Query("Select S FROM PersonaEntity S WHERE S.estado = 1 order by concat(S.nombre, concat(' ',S.apellido))")
    @Transactional(readOnly = true)
    List<PersonaEntity> obtenerListado();
}
