package com.mencarnacion.service;

import com.mencarnacion.model.rest.request.LaboratorioFabricanteRequest;
import com.mencarnacion.model.rest.response.LaboratorioFabricanteResponse;
import com.mencarnacion.model.rest.response.ListadoLaboratorioFabricanteResponse;


/**
 * Created by mencarnacion on 8/28/18.
 */
public interface LaboratorioFabricanteService {

    LaboratorioFabricanteResponse guardar(LaboratorioFabricanteRequest request);

    LaboratorioFabricanteResponse buscarPorId(Long id);

    ListadoLaboratorioFabricanteResponse obtenerListado();
}
