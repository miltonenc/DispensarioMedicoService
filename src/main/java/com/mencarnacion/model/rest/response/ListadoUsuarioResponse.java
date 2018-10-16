package com.mencarnacion.model.rest.response;

import com.mencarnacion.model.dto.UsuarioDTO;
import com.mencarnacion.model.entities.UsuarioEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * Created by mencarnacion on 10/07/18.
 */
public class ListadoUsuarioResponse {

    private RespuestaType respuesta;
    private List<UsuarioDTO> usuario;

    public ListadoUsuarioResponse() {
        super();
    }

    public ListadoUsuarioResponse(RespuestaType respuesta) {
        this.respuesta = respuesta;
    }

    public ListadoUsuarioResponse(RespuestaType respuesta, List<UsuarioEntity> usuarioEntityList) {
        this.respuesta = respuesta;
        setUsuario(usuarioEntityList);
    }

    public RespuestaType getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(RespuestaType respuesta) {
        this.respuesta = respuesta;
    }

    public List<UsuarioDTO> getUsuario() {
        return usuario;
    }

    public void setUsuario(List<UsuarioEntity> usuarioEntityList) {
        List<UsuarioDTO> usuarioDTOS = new ArrayList<>();
        if (Objects.nonNull(usuarioEntityList)) {
            for (UsuarioEntity usuarioEntity : usuarioEntityList) {
                usuarioDTOS.add(new UsuarioDTO(usuarioEntity.getId(), usuarioEntity.getUsuario(),
                        usuarioEntity.getPassword(), usuarioEntity.getRoles(), usuarioEntity.getMedicos(), usuarioEntity.getPacientes()));
            }

        }
        this.usuario = usuarioDTOS;
    }
}
