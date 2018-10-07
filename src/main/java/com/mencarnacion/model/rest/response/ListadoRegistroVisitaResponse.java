package com.mencarnacion.model.rest.response;

import com.mencarnacion.model.entities.RegistroVisitaEntity;

import java.util.List;

/**
 * Created by mencarnacion on 9/4/18.
 */
public class ListadoRegistroVisitaResponse {

    private RespuestaType respuesta;
    private List<RegistroVisitaEntity> registroVisitaEntityList;

    public ListadoRegistroVisitaResponse() {
        super();
    }

    public ListadoRegistroVisitaResponse(RespuestaType respuesta) {
        this.respuesta = respuesta;
    }

    public ListadoRegistroVisitaResponse(RespuestaType respuesta, List<RegistroVisitaEntity> registroVisitaEntityList) {
        this.respuesta = respuesta;
        this.registroVisitaEntityList = registroVisitaEntityList;
    }

    public RespuestaType getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(RespuestaType respuesta) {
        this.respuesta = respuesta;
    }

    public List<RegistroVisitaEntity> getRegistroVisitaEntityList() {
        return registroVisitaEntityList;
    }

    public void setRegistroVisitaEntityList(List<RegistroVisitaEntity> registroVisitaEntityList) {
        this.registroVisitaEntityList = registroVisitaEntityList;
    }
}
