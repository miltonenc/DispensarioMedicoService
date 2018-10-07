package com.mencarnacion.model.rest.response;

import com.mencarnacion.model.entities.UsuarioEntity;

import java.util.List;

/**
 * Created by mencarnacion on 10/07/18.
 */
public class ListadoUsuarioResponse {

    private RespuestaType respuesta;
    private List<UsuarioEntity> usuarioEntityList;

    public ListadoUsuarioResponse() {
        super();
    }

    public ListadoUsuarioResponse(RespuestaType respuesta) {
        this.respuesta = respuesta;
    }

    public ListadoUsuarioResponse(RespuestaType respuesta, List<UsuarioEntity> usuarioEntityList) {
        this.respuesta = respuesta;
        this.usuarioEntityList = usuarioEntityList;
    }

    public RespuestaType getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(RespuestaType respuesta) {
        this.respuesta = respuesta;
    }

    public List<UsuarioEntity> getUsuarioEntityList() {
        return usuarioEntityList;
    }

    public void setUsuarioEntityList(List<UsuarioEntity> usuarioEntityList) {
        this.usuarioEntityList = usuarioEntityList;
    }
}
