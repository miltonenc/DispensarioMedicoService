package com.mencarnacion.model.rest.response;

import com.mencarnacion.model.entities.MedicoEspecialidadEntity;

/**
 * Created by mencarnacion on 9/4/18.
 */
public class MedicoEspecialidadResponse {

    private RespuestaType respuesta;
    private MedicoEspecialidadEntity medicoEspecialidadEntity;

    public MedicoEspecialidadResponse() {
        super();
    }

    public MedicoEspecialidadResponse(RespuestaType respuesta) {
        this.respuesta = respuesta;
    }

    public MedicoEspecialidadResponse(RespuestaType respuesta, MedicoEspecialidadEntity medicoEspecialidadEntity) {
        this.respuesta = respuesta;
        this.medicoEspecialidadEntity = medicoEspecialidadEntity;
    }

    public RespuestaType getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(RespuestaType respuesta) {
        this.respuesta = respuesta;
    }

    public MedicoEspecialidadEntity getMedicoEspecialidadEntity() {
        return medicoEspecialidadEntity;
    }

    public void setMedicoEspecialidadEntity(MedicoEspecialidadEntity medicoEspecialidadEntity) {
        this.medicoEspecialidadEntity = medicoEspecialidadEntity;
    }
}
