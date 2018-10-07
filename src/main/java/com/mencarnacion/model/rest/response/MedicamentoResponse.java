package com.mencarnacion.model.rest.response;

import com.mencarnacion.model.entities.MedicamentoEntity;

/**
 * Created by mencarnacion on 9/4/18.
 */
public class MedicamentoResponse {

    private RespuestaType respuesta;
    private MedicamentoEntity medicamentoEntity;

    public MedicamentoResponse() {
        super();
    }

    public MedicamentoResponse(RespuestaType respuesta) {
        this.respuesta = respuesta;
    }

    public MedicamentoResponse(RespuestaType respuesta, MedicamentoEntity tipoPacienteEntity) {
        this.respuesta = respuesta;
        this.medicamentoEntity = tipoPacienteEntity;
    }

    public RespuestaType getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(RespuestaType respuesta) {
        this.respuesta = respuesta;
    }

    public MedicamentoEntity getMedicamentoEntity() {
        return medicamentoEntity;
    }

    public void setMedicamentoEntity(MedicamentoEntity tipoPacienteEntity) {
        this.medicamentoEntity = tipoPacienteEntity;
    }
}
