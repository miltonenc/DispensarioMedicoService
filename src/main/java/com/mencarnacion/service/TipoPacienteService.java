package com.mencarnacion.service;

import com.mencarnacion.model.rest.request.TipoPacienteRequest;
import com.mencarnacion.model.rest.response.ListadoTipoPacienteResponse;
import com.mencarnacion.model.rest.response.TipoPacienteResponse;


/**
 * Created by mencarnacion on 8/28/18.
 */
public interface TipoPacienteService {

    TipoPacienteResponse guardar(TipoPacienteRequest request);

    TipoPacienteResponse buscarPorId(Long id);

    ListadoTipoPacienteResponse obtenerListado();
}
