package com.mencarnacion.model.rest.response;

import com.mencarnacion.model.entities.UbicacionEntity;

import java.util.List;

/**
 * Created by mencarnacion on 9/4/18.
 */
public class ListadoUbicacionResponse {

    private RespuestaType respuesta;
    private List<UbicacionEntity> ubicacionEntityList;

    public ListadoUbicacionResponse() {
        super();
    }

    public ListadoUbicacionResponse(RespuestaType respuesta) {
        this.respuesta = respuesta;
    }

    public ListadoUbicacionResponse(RespuestaType respuesta, List<UbicacionEntity> ubicacionEntityList) {
        this.respuesta = respuesta;
        this.ubicacionEntityList = ubicacionEntityList;
    }

    public RespuestaType getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(RespuestaType respuesta) {
        this.respuesta = respuesta;
    }

    public List<UbicacionEntity> getUbicacionEntityList() {
        return ubicacionEntityList;
    }

    public void setUbicacionEntityList(List<UbicacionEntity> ubicacionEntityList) {
        this.ubicacionEntityList = ubicacionEntityList;
    }
}
