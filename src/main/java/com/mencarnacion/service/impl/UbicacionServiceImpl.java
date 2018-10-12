package com.mencarnacion.service.impl;

import com.mencarnacion.model.entities.UbicacionEntity;
import com.mencarnacion.model.rest.request.UbicacionRequest;
import com.mencarnacion.model.rest.response.ListadoUbicacionResponse;
import com.mencarnacion.model.rest.response.RespuestaType;
import com.mencarnacion.model.rest.response.UbicacionResponse;
import com.mencarnacion.repository.UbicacionRepository;
import com.mencarnacion.service.UbicacionService;
import com.mencarnacion.util.TipoMensaje;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * Created by mencarnacion on 8/28/18.
 */
@Service
public class UbicacionServiceImpl implements UbicacionService {

    @Autowired
    UbicacionRepository ubicacionRepository;

    @Override
    public UbicacionResponse guardar(UbicacionRequest request) {
       UbicacionResponse response = new UbicacionResponse();

        boolean isExisteRegistro = Objects.nonNull(request.getId()) ?
                ubicacionRepository.isExisteRegistroPorId(request.getId(), request.getEstante(), request.getTramo(), request.getCelda()) :
                ubicacionRepository.isExisteRegistro(request.getEstante(), request.getTramo(), request.getCelda());

        if(isExisteRegistro){
            response.setRespuesta(new RespuestaType(TipoMensaje.ERROR_DATOS_DUPLICADOS));
            return response;
        }

        final String TMP_CODIGO = "E" + request.getEstante() + "T" + request.getTramo() + "C" + request.getCelda();
        UbicacionEntity entity = ubicacionRepository.buscarPorId(Objects.nonNull(request.getId()) ? request.getId() : null);

        if (Objects.nonNull(entity)) {
            entity.setCodigo(TMP_CODIGO);
            entity.setEstante(request.getEstante());
            entity.setTramo(request.getTramo());
            entity.setCelda(request.getCelda());
            entity.setDescripcion(request.getDescripcion());
            entity.setEstado(request.getEstado());

            entity = ubicacionRepository.save(entity);

            if (Objects.nonNull(entity.getId())) {
                response.setUbicacionEntity(entity);
                response.setRespuesta(new RespuestaType(TipoMensaje.OK));
            } else {
                response.setRespuesta(new RespuestaType(TipoMensaje.ERROR_ACTUALIZANDO_DATOS));
            }

        } else {
            entity = new UbicacionEntity();
            entity.setCodigo(TMP_CODIGO);
            entity.setEstante(request.getEstante());
            entity.setTramo(request.getTramo());
            entity.setCelda(request.getCelda());
            entity.setDescripcion(request.getDescripcion());
            entity.setEstado(request.getEstado());

            entity = ubicacionRepository.save(entity);

            if (Objects.nonNull(entity.getId())) {
                response.setUbicacionEntity(entity);
                response.setRespuesta(new RespuestaType(TipoMensaje.OK));
            } else {
                response.setRespuesta(new RespuestaType(TipoMensaje.ERROR_INSERTANDO_DATOS));
            }
        }

        return response;
    }

    @Override
    public UbicacionResponse buscarPorId(Long id) {
        UbicacionResponse response = new UbicacionResponse();
        UbicacionEntity entity = ubicacionRepository.buscarPorId(id);

        if (Objects.nonNull(entity)) {
            response.setUbicacionEntity(entity);
            response.setRespuesta(new RespuestaType(TipoMensaje.OK));
        } else {
            response.setRespuesta(new RespuestaType(TipoMensaje.NO_SE_ENCONTRARON_DATOS));
        }

        return response;
    }

    @Override
    public UbicacionResponse buscarPorCodigo(String pCodigo) {
        UbicacionResponse response = new UbicacionResponse();
        UbicacionEntity entity = ubicacionRepository.buscarPorCodigo(pCodigo);

        if (Objects.nonNull(entity)) {
            response.setUbicacionEntity(entity);
            response.setRespuesta(new RespuestaType(TipoMensaje.OK));
        } else {
            response.setRespuesta(new RespuestaType(TipoMensaje.NO_SE_ENCONTRARON_DATOS));
        }

        return response;
    }

    @Override
    public ListadoUbicacionResponse obtenerListado() {
        ListadoUbicacionResponse response = new ListadoUbicacionResponse();
        List<UbicacionEntity> entityList = ubicacionRepository.obtenerListado();

        if (Objects.nonNull(entityList) && !entityList.isEmpty()) {
            response.setUbicacionEntityList(entityList);
            response.setRespuesta(new RespuestaType(TipoMensaje.OK));
        } else {
            response.setRespuesta(new RespuestaType(TipoMensaje.NO_SE_ENCONTRARON_DATOS));
        }

        return response;
    }
}
