package com.mencarnacion.service;

import com.mencarnacion.model.rest.request.TipoMedicamentoRequest;
import com.mencarnacion.model.rest.response.ListadoTipoMedicamentoResponse;
import com.mencarnacion.model.rest.response.TipoMedicamentoResponse;


/**
 * Created by mencarnacion on 8/28/18.
 */
public interface TipoMedicamentoService {

    TipoMedicamentoResponse guardar(TipoMedicamentoRequest request);

    TipoMedicamentoResponse buscarPorId(Long id);

    ListadoTipoMedicamentoResponse obtenerListado();
}
