package com.mencarnacion.repository;

import com.mencarnacion.model.entities.RegistroVisitaEntity;
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
public interface RegistroVisitaRepository extends CrudRepository<RegistroVisitaEntity, Long> {

    @Query("Select S FROM RegistroVisitaEntity S WHERE S.id = :id and S.estado = 1")
    @Transactional(readOnly = true)
    RegistroVisitaEntity buscarPorId(@Param("id") Long id);


    @Query("Select S FROM RegistroVisitaEntity S WHERE S.estado = 1 order by S.fecha desc")
    @Transactional(readOnly = true)
    List<RegistroVisitaEntity> obtenerListado();


    @Query("Select S FROM RegistroVisitaEntity S WHERE S.estado = 1 " +
            " and S.paciente.id = :pacienteId order by S.fecha desc")
    @Transactional(readOnly = true)
    List<RegistroVisitaEntity> obtenerListadoPorPaciente(@Param("pacienteId") Long pacienteId);


    @Query("Select S FROM RegistroVisitaEntity S WHERE S.estado = 1 " +
            " and S.medico.id = :medicoId order by S.fecha desc")
    @Transactional(readOnly = true)
    List<RegistroVisitaEntity> obtenerListadoPorMedico(@Param("medicoId") Long medicoId);
}
