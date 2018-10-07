package com.mencarnacion.service;

import com.mencarnacion.model.rest.request.MedicamentoRequest;
import com.mencarnacion.model.rest.response.ListadoMedicamentoResponse;
import com.mencarnacion.model.rest.response.MedicamentoResponse;


/**
 * Created by mencarnacion on 8/28/18.
 */
public interface MedicamentoService {

    MedicamentoResponse guardar(MedicamentoRequest request);

    MedicamentoResponse buscarPorId(Long id);

    ListadoMedicamentoResponse obtenerListado();
}
