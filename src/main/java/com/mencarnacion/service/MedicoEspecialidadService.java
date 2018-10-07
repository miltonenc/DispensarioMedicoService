package com.mencarnacion.service;

import com.mencarnacion.model.rest.request.MedicoEspecialidadRequest;
import com.mencarnacion.model.rest.response.ListadoMedicoEspecialidadResponse;
import com.mencarnacion.model.rest.response.MedicoEspecialidadResponse;


/**
 * Created by mencarnacion on 8/28/18.
 */
public interface MedicoEspecialidadService {

    MedicoEspecialidadResponse guardar(MedicoEspecialidadRequest request);

    MedicoEspecialidadResponse buscarPorId(Long id);

    ListadoMedicoEspecialidadResponse obtenerListado();
}
