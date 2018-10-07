package com.mencarnacion.service;

import com.mencarnacion.model.rest.request.UbicacionRequest;
import com.mencarnacion.model.rest.response.ListadoUbicacionResponse;
import com.mencarnacion.model.rest.response.UbicacionResponse;


/**
 * Created by mencarnacion on 8/28/18.
 */
public interface UbicacionService {

    UbicacionResponse guardar(UbicacionRequest request);

    UbicacionResponse buscarPorId(Long id);

    UbicacionResponse buscarPorCodigo(String pCodigo);

    ListadoUbicacionResponse obtenerListado();
}
