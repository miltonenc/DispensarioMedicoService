package com.mencarnacion.service.impl;

import com.mencarnacion.model.entities.TipoPacienteEntity;
import com.mencarnacion.model.rest.request.TipoPacienteRequest;
import com.mencarnacion.model.rest.response.ListadoTipoPacienteResponse;
import com.mencarnacion.model.rest.response.RespuestaType;
import com.mencarnacion.model.rest.response.TipoPacienteResponse;
import com.mencarnacion.repository.TipoPacienteRepository;
import com.mencarnacion.service.TipoPacienteService;
import com.mencarnacion.util.TipoMensaje;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * Created by mencarnacion on 8/28/18.
 */
@Service
public class TipoPacienteServiceImpl implements TipoPacienteService {

    @Autowired
    TipoPacienteRepository tipoPacienteRepository;

    @Override
    public TipoPacienteResponse guardar(TipoPacienteRequest request) {
        TipoPacienteResponse response = new TipoPacienteResponse();
        TipoPacienteEntity entity = tipoPacienteRepository.buscarPorId(Objects.nonNull(request.getId()) ? request.getId() : null);

        if (Objects.nonNull(entity)) {
            entity.setNombre(request.getNombre());
            entity.setDescripcion(request.getDescripcion());
            entity.setEstado(request.getEstado());

            entity = tipoPacienteRepository.save(entity);

            if (Objects.nonNull(entity.getId())) {
                response.setTipoPacienteEntity(entity);
                response.setRespuesta(new RespuestaType(TipoMensaje.OK));
            } else {
                response.setRespuesta(new RespuestaType(TipoMensaje.ERROR_ACTUALIZANDO_DATOS));
            }

        } else {
            entity = new TipoPacienteEntity();
            entity.setNombre(request.getNombre());
            entity.setDescripcion(request.getDescripcion());

            entity = tipoPacienteRepository.save(entity);

            if (Objects.nonNull(entity.getId())) {
                response.setTipoPacienteEntity(entity);
                response.setRespuesta(new RespuestaType(TipoMensaje.OK));
            } else {
                response.setRespuesta(new RespuestaType(TipoMensaje.ERROR_INSERTANDO_DATOS));
            }
        }

        return response;
    }

    @Override
    public TipoPacienteResponse buscarPorId(Long id) {
        TipoPacienteResponse response = new TipoPacienteResponse();
        TipoPacienteEntity entity = tipoPacienteRepository.buscarPorId(id);

        if (Objects.nonNull(entity)) {
            response.setTipoPacienteEntity(entity);
            response.setRespuesta(new RespuestaType(TipoMensaje.OK));
        } else {
            response.setRespuesta(new RespuestaType(TipoMensaje.NO_SE_ENCONTRARON_DATOS));
        }

        return response;
    }

    @Override
    public ListadoTipoPacienteResponse obtenerListado() {
        ListadoTipoPacienteResponse response = new ListadoTipoPacienteResponse();
        List<TipoPacienteEntity> entityList = tipoPacienteRepository.obtenerListado();

        if (Objects.nonNull(entityList) && !entityList.isEmpty()) {
            response.setTipoPacienteEntityList(entityList);
            response.setRespuesta(new RespuestaType(TipoMensaje.OK));
        } else {
            response.setRespuesta(new RespuestaType(TipoMensaje.NO_SE_ENCONTRARON_DATOS));
        }

        return response;
    }
}
