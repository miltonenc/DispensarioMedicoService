package com.mencarnacion.model.rest.response;

import com.mencarnacion.model.entities.MedicoEspecialidadEntity;

/**
 * Created by mencarnacion on 9/4/18.
 */
public class MedicoEspecialidadResponse {

    private RespuestaType respuesta;
    private MedicoEspecialidadEntity especialidad;

    public MedicoEspecialidadResponse() {
        super();
    }

    public MedicoEspecialidadResponse(RespuestaType respuesta) {
        this.respuesta = respuesta;
    }

    public MedicoEspecialidadResponse(RespuestaType respuesta, MedicoEspecialidadEntity medicoEspecialidadEntity) {
        this.respuesta = respuesta;
        this.especialidad = medicoEspecialidadEntity;
    }

    public RespuestaType getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(RespuestaType respuesta) {
        this.respuesta = respuesta;
    }

    public MedicoEspecialidadEntity getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(MedicoEspecialidadEntity especialidad) {
        this.especialidad = especialidad;
    }
}
