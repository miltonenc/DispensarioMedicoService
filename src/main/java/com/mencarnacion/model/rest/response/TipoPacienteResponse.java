package com.mencarnacion.model.rest.response;

import com.mencarnacion.model.entities.TipoPacienteEntity;

/**
 * Created by mencarnacion on 9/4/18.
 */
public class TipoPacienteResponse {

    private RespuestaType respuesta;
    private TipoPacienteEntity tipoPacienteEntity;

    public TipoPacienteResponse() {
        super();
    }

    public TipoPacienteResponse(RespuestaType respuesta) {
        this.respuesta = respuesta;
    }

    public TipoPacienteResponse(RespuestaType respuesta, TipoPacienteEntity tipoPacienteEntity) {
        this.respuesta = respuesta;
        this.tipoPacienteEntity = tipoPacienteEntity;
    }

    public RespuestaType getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(RespuestaType respuesta) {
        this.respuesta = respuesta;
    }

    public TipoPacienteEntity getTipoPacienteEntity() {
        return tipoPacienteEntity;
    }

    public void setTipoPacienteEntity(TipoPacienteEntity tipoPacienteEntity) {
        this.tipoPacienteEntity = tipoPacienteEntity;
    }
}
