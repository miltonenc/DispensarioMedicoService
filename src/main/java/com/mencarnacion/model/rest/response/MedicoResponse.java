package com.mencarnacion.model.rest.response;

import com.mencarnacion.model.entities.MedicoEntity;

/**
 * Created by mencarnacion on 9/4/18.
 */
public class MedicoResponse {

    private RespuestaType respuesta;
    private MedicoEntity medicoEntity;

    public MedicoResponse() {
        super();
    }

    public MedicoResponse(RespuestaType respuesta) {
        this.respuesta = respuesta;
    }

    public MedicoResponse(RespuestaType respuesta, MedicoEntity medicoEntity) {
        this.respuesta = respuesta;
        this.medicoEntity = medicoEntity;
    }

    public RespuestaType getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(RespuestaType respuesta) {
        this.respuesta = respuesta;
    }

    public MedicoEntity getMedicoEntity() {
        return medicoEntity;
    }

    public void setMedicoEntity(MedicoEntity medicoEntity) {
        this.medicoEntity = medicoEntity;
    }
}
