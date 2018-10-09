package com.mencarnacion.service.impl;

import com.mencarnacion.model.entities.UsuarioEntity;
import com.mencarnacion.model.rest.request.UsuarioRequest;
import com.mencarnacion.model.rest.response.ListadoUsuarioResponse;
import com.mencarnacion.model.rest.response.RespuestaType;
import com.mencarnacion.model.rest.response.UsuarioResponse;
import com.mencarnacion.repository.UsuarioRepository;
import com.mencarnacion.service.UsuarioService;
import com.mencarnacion.service.UsuarioService;
import com.mencarnacion.util.TipoMensaje;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * Created by mencarnacion on 10/07/18.
 */
@Service
public class UsuarioServiceImpl implements UsuarioService {

    @Autowired
    UsuarioRepository UsuarioRepository;

    @Override
    public UsuarioResponse buscarPorId(Long id) {
        UsuarioResponse response = new UsuarioResponse();
        UsuarioEntity entity = UsuarioRepository.buscarPorId(id);

        if (Objects.nonNull(entity)) {
            response.setUsuario(entity);
            response.setRespuesta(new RespuestaType(TipoMensaje.OK));
        } else {
            response.setRespuesta(new RespuestaType(TipoMensaje.NO_SE_ENCONTRARON_DATOS));
        }

        return response;
    }

    @Override
    public UsuarioResponse login(String pUsuario, String pPassword){
        UsuarioResponse response = new UsuarioResponse();
        UsuarioEntity entity = UsuarioRepository.login(pUsuario, pPassword);

        if (Objects.nonNull(entity)) {
            response.setUsuario(entity);
            response.setRespuesta(new RespuestaType(TipoMensaje.OK));
        } else {
            response.setRespuesta(new RespuestaType(TipoMensaje.NO_SE_ENCONTRARON_DATOS));
        }

        return response;
    }

    @Override
    public ListadoUsuarioResponse obtenerListado() {
        ListadoUsuarioResponse response = new ListadoUsuarioResponse();
        List<UsuarioEntity> entityList = UsuarioRepository.obtenerListado();

        if (Objects.nonNull(entityList) && !entityList.isEmpty()) {
            response.setUsuario(entityList);
            response.setRespuesta(new RespuestaType(TipoMensaje.OK));
        } else {
            response.setRespuesta(new RespuestaType(TipoMensaje.NO_SE_ENCONTRARON_DATOS));
        }

        return response;
    }

    @Override
    public ListadoUsuarioResponse obtenerListadoByUsuario(String pUsuario) {
        ListadoUsuarioResponse response = new ListadoUsuarioResponse();
        List<UsuarioEntity> entityList = UsuarioRepository.obtenerListadoByUsuario(pUsuario);

        if (Objects.nonNull(entityList) && !entityList.isEmpty()) {
            response.setUsuario(entityList);
            response.setRespuesta(new RespuestaType(TipoMensaje.OK));
        } else {
            response.setRespuesta(new RespuestaType(TipoMensaje.NO_SE_ENCONTRARON_DATOS));
        }

        return response;
    }
}
