package com.mencarnacion.service;

import com.mencarnacion.model.rest.request.MedicoRequest;
import com.mencarnacion.model.rest.response.ListadoMedicoResponse;
import com.mencarnacion.model.rest.response.MedicoResponse;


/**
 * Created by mencarnacion on 8/28/18.
 */
public interface MedicoService {

    MedicoResponse guardar(MedicoRequest request);

    MedicoResponse buscarPorId(Long id);

    ListadoMedicoResponse obtenerListado();
}
