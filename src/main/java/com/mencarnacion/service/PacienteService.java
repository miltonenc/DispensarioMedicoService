package com.mencarnacion.service;

import com.mencarnacion.model.rest.request.PacienteRequest;
import com.mencarnacion.model.rest.response.ListadoPacienteResponse;
import com.mencarnacion.model.rest.response.PacienteResponse;


/**
 * Created by mencarnacion on 8/28/18.
 */
public interface PacienteService {

    PacienteResponse guardar(PacienteRequest request);

    PacienteResponse buscarPorId(Long id);

    ListadoPacienteResponse obtenerListado();
}
