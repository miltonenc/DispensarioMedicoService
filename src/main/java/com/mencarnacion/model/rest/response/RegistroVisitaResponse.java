package com.mencarnacion.model.rest.response;

import com.mencarnacion.model.dto.RegistroVisitaDTO;

/**
 * Created by mencarnacion on 9/4/18.
 */
public class RegistroVisitaResponse {

    private RespuestaType respuesta;
    private RegistroVisitaDTO registroVisita;

    public RegistroVisitaResponse() {
        super();
    }

    public RegistroVisitaResponse(RespuestaType respuesta) {
        this.respuesta = respuesta;
    }

    public RegistroVisitaResponse(RespuestaType respuesta, RegistroVisitaDTO registroVisitaEntity) {
        this.respuesta = respuesta;
        this.registroVisita = registroVisitaEntity;
    }

    public RespuestaType getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(RespuestaType respuesta) {
        this.respuesta = respuesta;
    }

    public RegistroVisitaDTO getRegistroVisita() {
        return registroVisita;
    }

    public void setRegistroVisita(RegistroVisitaDTO registroVisita) {
        this.registroVisita = registroVisita;
    }
}
