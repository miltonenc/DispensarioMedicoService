package com.mencarnacion.service.impl;

import com.mencarnacion.model.entities.LaboratorioFabricanteEntity;
import com.mencarnacion.model.rest.request.LaboratorioFabricanteRequest;
import com.mencarnacion.model.rest.response.LaboratorioFabricanteResponse;
import com.mencarnacion.model.rest.response.ListadoLaboratorioFabricanteResponse;
import com.mencarnacion.model.rest.response.RespuestaType;
import com.mencarnacion.repository.LaboratorioFabricanteRepository;
import com.mencarnacion.service.LaboratorioFabricanteService;
import com.mencarnacion.util.TipoMensaje;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * Created by mencarnacion on 8/28/18.
 */
@Service
public class LaboratorioFabricanteServiceImpl implements LaboratorioFabricanteService {

    @Autowired
    LaboratorioFabricanteRepository laboratorioFabricanteRepository;

    @Override
    public LaboratorioFabricanteResponse guardar(LaboratorioFabricanteRequest request) {
        LaboratorioFabricanteResponse response = new LaboratorioFabricanteResponse();

        boolean isExisteRegistro = Objects.nonNull(request.getId()) ?
                laboratorioFabricanteRepository.isExisteRegistroPorId(request.getNombre().trim(), request.getId()) :
                laboratorioFabricanteRepository.isExisteRegistro(request.getNombre().trim());

        if(isExisteRegistro){
            response.setRespuesta(new RespuestaType(TipoMensaje.ERROR_DATOS_DUPLICADOS));
            return response;
        }

        LaboratorioFabricanteEntity entity = laboratorioFabricanteRepository.buscarPorId(Objects.nonNull(request.getId()) ? request.getId() : null);

        if (Objects.nonNull(entity)) {
            entity.setNombre(request.getNombre());
            entity.setDescripcion(request.getDescripcion());
            entity.setEstado(request.getEstado());

            entity = laboratorioFabricanteRepository.save(entity);

            if (Objects.nonNull(entity.getId())) {
                response.setLaboratorioFabricante(entity);
                response.setRespuesta(new RespuestaType(TipoMensaje.OK));
            } else {
                response.setRespuesta(new RespuestaType(TipoMensaje.ERROR_ACTUALIZANDO_DATOS));
            }

        } else {
            entity = new LaboratorioFabricanteEntity();
            entity.setNombre(request.getNombre());
            entity.setDescripcion(request.getDescripcion());

            entity = laboratorioFabricanteRepository.save(entity);

            if (Objects.nonNull(entity.getId())) {
                response.setLaboratorioFabricante(entity);
                response.setRespuesta(new RespuestaType(TipoMensaje.OK));
            } else {
                response.setRespuesta(new RespuestaType(TipoMensaje.ERROR_INSERTANDO_DATOS));
            }
        }

        return response;
    }

    @Override
    public LaboratorioFabricanteResponse buscarPorId(Long id) {
        LaboratorioFabricanteResponse response = new LaboratorioFabricanteResponse();
        LaboratorioFabricanteEntity entity = laboratorioFabricanteRepository.buscarPorId(id);

        if (Objects.nonNull(entity)) {
            response.setLaboratorioFabricante(entity);
            response.setRespuesta(new RespuestaType(TipoMensaje.OK));
        } else {
            response.setRespuesta(new RespuestaType(TipoMensaje.NO_SE_ENCONTRARON_DATOS));
        }

        return response;
    }

    @Override
    public ListadoLaboratorioFabricanteResponse obtenerListado() {
        ListadoLaboratorioFabricanteResponse response = new ListadoLaboratorioFabricanteResponse();
        List<LaboratorioFabricanteEntity> entityList = laboratorioFabricanteRepository.obtenerListado();

        if (Objects.nonNull(entityList) && !entityList.isEmpty()) {
            response.setLaboratorioFabricantes(entityList);
            response.setRespuesta(new RespuestaType(TipoMensaje.OK));
        } else {
            response.setRespuesta(new RespuestaType(TipoMensaje.NO_SE_ENCONTRARON_DATOS));
        }

        return response;
    }
}
