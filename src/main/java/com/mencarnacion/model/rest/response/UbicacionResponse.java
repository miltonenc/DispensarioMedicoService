package com.mencarnacion.model.rest.response;

import com.mencarnacion.model.entities.UbicacionEntity;

/**
 * Created by mencarnacion on 9/4/18.
 */
public class UbicacionResponse {

    private RespuestaType respuesta;
    private UbicacionEntity ubicacionEntity;

    public UbicacionResponse() {
        super();
    }

    public UbicacionResponse(RespuestaType respuesta) {
        this.respuesta = respuesta;
    }

    public UbicacionResponse(RespuestaType respuesta, UbicacionEntity ubicacionEntity) {
        this.respuesta = respuesta;
        this.ubicacionEntity = ubicacionEntity;
    }

    public RespuestaType getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(RespuestaType respuesta) {
        this.respuesta = respuesta;
    }

    public UbicacionEntity getUbicacionEntity() {
        return ubicacionEntity;
    }

    public void setUbicacionEntity(UbicacionEntity ubicacionEntity) {
        this.ubicacionEntity = ubicacionEntity;
    }
}
