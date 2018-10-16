package com.mencarnacion.service;

import com.mencarnacion.model.rest.request.RegistroVisitaRequest;
import com.mencarnacion.model.rest.response.ListadoRegistroVisitaResponse;
import com.mencarnacion.model.rest.response.RegistroVisitaResponse;


/**
 * Created by mencarnacion on 8/28/18.
 */
public interface RegistroVisitaService {

    RegistroVisitaResponse guardar(RegistroVisitaRequest request);

    RegistroVisitaResponse buscarPorId(Long id);

    ListadoRegistroVisitaResponse obtenerListado();

    ListadoRegistroVisitaResponse obtenerListadoPorMedico(Long medicoId);

    ListadoRegistroVisitaResponse obtenerListadoPorPaciente(Long pacienteId);
}
