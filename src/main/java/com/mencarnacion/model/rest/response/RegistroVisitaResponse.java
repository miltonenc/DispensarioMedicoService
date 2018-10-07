package com.mencarnacion.model.rest.response;

import com.mencarnacion.model.entities.RegistroVisitaEntity;

/**
 * Created by mencarnacion on 9/4/18.
 */
public class RegistroVisitaResponse {

    private RespuestaType respuesta;
    private RegistroVisitaEntity registroVisitaEntity;

    public RegistroVisitaResponse() {
        super();
    }

    public RegistroVisitaResponse(RespuestaType respuesta) {
        this.respuesta = respuesta;
    }

    public RegistroVisitaResponse(RespuestaType respuesta, RegistroVisitaEntity registroVisitaEntity) {
        this.respuesta = respuesta;
        this.registroVisitaEntity = registroVisitaEntity;
    }

    public RespuestaType getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(RespuestaType respuesta) {
        this.respuesta = respuesta;
    }

    public RegistroVisitaEntity getRegistroVisitaEntity() {
        return registroVisitaEntity;
    }

    public void setRegistroVisitaEntity(RegistroVisitaEntity registroVisitaEntity) {
        this.registroVisitaEntity = registroVisitaEntity;
    }
}
