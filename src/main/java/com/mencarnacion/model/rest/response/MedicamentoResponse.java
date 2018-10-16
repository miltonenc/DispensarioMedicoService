package com.mencarnacion.model.rest.response;

import com.mencarnacion.model.dto.MedicamentoDTO;

/**
 * Created by mencarnacion on 9/4/18.
 */
public class MedicamentoResponse {

    private RespuestaType respuesta;
    private MedicamentoDTO medicamento;

    public MedicamentoResponse() {
        super();
    }

    public MedicamentoResponse(RespuestaType respuesta) {
        this.respuesta = respuesta;
    }

    public MedicamentoResponse(RespuestaType respuesta, MedicamentoDTO tipoPacienteEntity) {
        this.respuesta = respuesta;
        this.medicamento = tipoPacienteEntity;
    }

    public RespuestaType getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(RespuestaType respuesta) {
        this.respuesta = respuesta;
    }

    public MedicamentoDTO getMedicamento() {
        return medicamento;
    }

    public void setMedicamento(MedicamentoDTO tipoPacienteEntity) {
        this.medicamento = tipoPacienteEntity;
    }
}
