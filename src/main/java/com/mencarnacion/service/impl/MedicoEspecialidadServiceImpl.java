package com.mencarnacion.service.impl;

import com.mencarnacion.model.entities.MedicoEspecialidadEntity;
import com.mencarnacion.model.rest.request.MedicoEspecialidadRequest;
import com.mencarnacion.model.rest.response.ListadoMedicoEspecialidadResponse;
import com.mencarnacion.model.rest.response.MedicoEspecialidadResponse;
import com.mencarnacion.model.rest.response.RespuestaType;
import com.mencarnacion.repository.MedicoEspecialidadRepository;
import com.mencarnacion.service.MedicoEspecialidadService;
import com.mencarnacion.util.TipoMensaje;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * Created by mencarnacion on 8/28/18.
 */
@Service
public class MedicoEspecialidadServiceImpl implements MedicoEspecialidadService {

    @Autowired
    MedicoEspecialidadRepository medicoEspecialidadRepository;

    @Override
    public MedicoEspecialidadResponse guardar(MedicoEspecialidadRequest request) {
        MedicoEspecialidadResponse response = new MedicoEspecialidadResponse();

        boolean isExisteRegistro = Objects.nonNull(request.getId()) ?
                medicoEspecialidadRepository.isExisteRegistroPorId(request.getNombre().trim(), request.getId()) :
                medicoEspecialidadRepository.isExisteRegistro(request.getNombre().trim());

        if (isExisteRegistro) {
            response.setRespuesta(new RespuestaType(TipoMensaje.ERROR_DATOS_DUPLICADOS));
            return response;
        }

        MedicoEspecialidadEntity entity = medicoEspecialidadRepository.buscarPorId(Objects.nonNull(request.getId()) ? request.getId() : null);

        if (Objects.nonNull(entity)) {
            entity.setNombre(request.getNombre());
            entity.setEstado(request.getEstado());

            entity = medicoEspecialidadRepository.save(entity);

            if (Objects.nonNull(entity.getId())) {
                response.setEspecialidad(entity);
                response.setRespuesta(new RespuestaType(TipoMensaje.OK));
            } else {
                response.setRespuesta(new RespuestaType(TipoMensaje.ERROR_ACTUALIZANDO_DATOS));
            }

        } else {
            entity = new MedicoEspecialidadEntity();
            entity.setNombre(request.getNombre());

            entity = medicoEspecialidadRepository.save(entity);

            if (Objects.nonNull(entity.getId())) {
                response.setEspecialidad(entity);
                response.setRespuesta(new RespuestaType(TipoMensaje.OK));
            } else {
                response.setRespuesta(new RespuestaType(TipoMensaje.ERROR_INSERTANDO_DATOS));
            }
        }

        return response;
    }

    @Override
    public MedicoEspecialidadResponse buscarPorId(Long id) {
        MedicoEspecialidadResponse response = new MedicoEspecialidadResponse();
        MedicoEspecialidadEntity entity = medicoEspecialidadRepository.buscarPorId(id);

        if (Objects.nonNull(entity)) {
            response.setEspecialidad(entity);
            response.setRespuesta(new RespuestaType(TipoMensaje.OK));
        } else {
            response.setRespuesta(new RespuestaType(TipoMensaje.NO_SE_ENCONTRARON_DATOS));
        }

        return response;
    }

    @Override
    public ListadoMedicoEspecialidadResponse obtenerListado() {
        ListadoMedicoEspecialidadResponse response = new ListadoMedicoEspecialidadResponse();
        List<MedicoEspecialidadEntity> entityList = medicoEspecialidadRepository.obtenerListado();

        if (Objects.nonNull(entityList) && !entityList.isEmpty()) {
            response.setEspecialidades(entityList);
            response.setRespuesta(new RespuestaType(TipoMensaje.OK));
        } else {
            response.setRespuesta(new RespuestaType(TipoMensaje.NO_SE_ENCONTRARON_DATOS));
        }

        return response;
    }
}
