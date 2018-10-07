package com.mencarnacion.model.rest.response;

import com.mencarnacion.model.entities.PacienteEntity;

/**
 * Created by mencarnacion on 9/4/18.
 */
public class PacienteResponse {

    private RespuestaType respuesta;
    private PacienteEntity pacienteEntity;

    public PacienteResponse() {
        super();
    }

    public PacienteResponse(RespuestaType respuesta) {
        this.respuesta = respuesta;
    }

    public PacienteResponse(RespuestaType respuesta, PacienteEntity pacienteEntity) {
        this.respuesta = respuesta;
        this.pacienteEntity = pacienteEntity;
    }

    public RespuestaType getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(RespuestaType respuesta) {
        this.respuesta = respuesta;
    }

    public PacienteEntity getPacienteEntity() {
        return pacienteEntity;
    }

    public void setPacienteEntity(PacienteEntity pacienteEntity) {
        this.pacienteEntity = pacienteEntity;
    }
}
