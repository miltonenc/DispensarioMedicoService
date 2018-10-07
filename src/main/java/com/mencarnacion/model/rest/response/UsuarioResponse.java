package com.mencarnacion.model.rest.response;

import com.mencarnacion.model.entities.UsuarioEntity;

/**
 * Created by mencarnacion on 10/07/18.
 */
public class UsuarioResponse {

    private RespuestaType respuesta;
    private UsuarioEntity usuarioEntity;

    public UsuarioResponse() {
        super();
    }

    public UsuarioResponse(RespuestaType respuesta) {
        this.respuesta = respuesta;
    }

    public UsuarioResponse(RespuestaType respuesta, UsuarioEntity usuarioEntity) {
        this.respuesta = respuesta;
        this.usuarioEntity = usuarioEntity;
    }

    public RespuestaType getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(RespuestaType respuesta) {
        this.respuesta = respuesta;
    }

    public UsuarioEntity getUsuarioEntity() {
        return usuarioEntity;
    }

    public void setUsuarioEntity(UsuarioEntity usuarioEntity) {
        this.usuarioEntity = usuarioEntity;
    }
}
