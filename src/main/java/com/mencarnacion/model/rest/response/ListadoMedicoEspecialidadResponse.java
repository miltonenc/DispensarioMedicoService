package com.mencarnacion.model.rest.response;

import com.mencarnacion.model.entities.MedicoEspecialidadEntity;

import java.util.List;

/**
 * Created by mencarnacion on 9/4/18.
 */
public class ListadoMedicoEspecialidadResponse {

    private RespuestaType respuesta;
    private List<MedicoEspecialidadEntity> medicoEspecialidadEntityList;

    public ListadoMedicoEspecialidadResponse() {
        super();
    }

    public ListadoMedicoEspecialidadResponse(RespuestaType respuesta) {
        this.respuesta = respuesta;
    }

    public ListadoMedicoEspecialidadResponse(RespuestaType respuesta, List<MedicoEspecialidadEntity> medicoEspecialidadEntityList) {
        this.respuesta = respuesta;
        this.medicoEspecialidadEntityList = medicoEspecialidadEntityList;
    }

    public RespuestaType getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(RespuestaType respuesta) {
        this.respuesta = respuesta;
    }

    public List<MedicoEspecialidadEntity> getMedicoEspecialidadEntityList() {
        return medicoEspecialidadEntityList;
    }

    public void setMedicoEspecialidadEntityList(List<MedicoEspecialidadEntity> medicoEspecialidadEntityList) {
        this.medicoEspecialidadEntityList = medicoEspecialidadEntityList;
    }
}
