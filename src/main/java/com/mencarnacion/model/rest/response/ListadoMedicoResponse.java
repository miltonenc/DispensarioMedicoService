package com.mencarnacion.model.rest.response;

import com.mencarnacion.model.entities.MedicoEntity;

import java.util.List;

/**
 * Created by mencarnacion on 9/4/18.
 */
public class ListadoMedicoResponse {

    private RespuestaType respuesta;
    private List<MedicoEntity> medicoEntityList;

    public ListadoMedicoResponse() {
        super();
    }

    public ListadoMedicoResponse(RespuestaType respuesta) {
        this.respuesta = respuesta;
    }

    public ListadoMedicoResponse(RespuestaType respuesta, List<MedicoEntity> medicoEntityList) {
        this.respuesta = respuesta;
        this.medicoEntityList = medicoEntityList;
    }

    public RespuestaType getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(RespuestaType respuesta) {
        this.respuesta = respuesta;
    }

    public List<MedicoEntity> getMedicoEntityList() {
        return medicoEntityList;
    }

    public void setMedicoEntityList(List<MedicoEntity> medicoEntityList) {
        this.medicoEntityList = medicoEntityList;
    }
}
