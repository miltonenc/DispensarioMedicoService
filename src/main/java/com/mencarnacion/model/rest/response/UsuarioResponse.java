package com.mencarnacion.model.rest.response;

import com.mencarnacion.model.dto.UsuarioDTO;
import com.mencarnacion.model.entities.UsuarioEntity;

/**
 * Created by mencarnacion on 10/07/18.
 */
public class UsuarioResponse {

    private RespuestaType respuesta;
    private UsuarioDTO usuario;

    public UsuarioResponse() {
        super();
    }

    public UsuarioResponse(RespuestaType respuesta) {
        this.respuesta = respuesta;
    }

    public UsuarioResponse(RespuestaType respuesta, UsuarioEntity usuarioEntity) {
        this.respuesta = respuesta;
        setUsuario(usuarioEntity);
    }

    public RespuestaType getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(RespuestaType respuesta) {
        this.respuesta = respuesta;
    }

    public UsuarioDTO getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioEntity usuarioEntity) {
        this.usuario = new UsuarioDTO(usuarioEntity.getId(), usuarioEntity.getUsuario(),
                usuarioEntity.getPassword(), usuarioEntity.getRoles(), usuarioEntity.getMedicos(), usuarioEntity.getPacientes());
    }
}
