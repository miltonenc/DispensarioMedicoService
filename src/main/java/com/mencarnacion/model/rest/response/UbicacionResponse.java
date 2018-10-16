package com.mencarnacion.model.rest.response;

import com.mencarnacion.model.entities.UbicacionEntity;

/**
 * Created by mencarnacion on 9/4/18.
 */
public class UbicacionResponse {

    private RespuestaType respuesta;
    private UbicacionEntity ubicacion;

    public UbicacionResponse() {
        super();
    }

    public UbicacionResponse(RespuestaType respuesta) {
        this.respuesta = respuesta;
    }

    public UbicacionResponse(RespuestaType respuesta, UbicacionEntity ubicacionEntity) {
        this.respuesta = respuesta;
        this.ubicacion = ubicacionEntity;
    }

    public RespuestaType getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(RespuestaType respuesta) {
        this.respuesta = respuesta;
    }

    public UbicacionEntity getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(UbicacionEntity ubicacion) {
        ubicacion.setMedicamentos(null);
        this.ubicacion = ubicacion;
    }
}
