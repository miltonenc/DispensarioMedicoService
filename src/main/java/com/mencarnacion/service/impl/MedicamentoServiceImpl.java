package com.mencarnacion.service.impl;

import com.mencarnacion.model.entities.MedicamentoEntity;
import com.mencarnacion.model.rest.request.MedicamentoRequest;
import com.mencarnacion.model.rest.response.ListadoMedicamentoResponse;
import com.mencarnacion.model.rest.response.MedicamentoResponse;
import com.mencarnacion.model.rest.response.RespuestaType;
import com.mencarnacion.repository.LaboratorioFabricanteRepository;
import com.mencarnacion.repository.MedicamentoRepository;
import com.mencarnacion.repository.TipoMedicamentoRepository;
import com.mencarnacion.repository.UbicacionRepository;
import com.mencarnacion.service.MedicamentoService;
import com.mencarnacion.util.TipoMensaje;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * Created by mencarnacion on 8/28/18.
 */
@Service
public class MedicamentoServiceImpl implements MedicamentoService {

    @Autowired
    MedicamentoRepository medicamentoRepository;

    @Autowired
    LaboratorioFabricanteRepository laboratorioFabricanteRepository;

    @Autowired
    TipoMedicamentoRepository tipoMedicamentoRepository;

    @Autowired
    UbicacionRepository ubicacionRepository;

    @Override
    public MedicamentoResponse guardar(MedicamentoRequest request) {
        MedicamentoResponse response = new MedicamentoResponse();
        MedicamentoEntity entity = medicamentoRepository.buscarPorId(Objects.nonNull(request.getId()) ? request.getId() : null);

        if (Objects.nonNull(entity)) {
            entity.setNombre(request.getNombre());
            entity.setDescripcion(request.getDescripcion());
            entity.setDosis(request.getDosis());
            entity.setFabricante(laboratorioFabricanteRepository.buscarPorId(request.getFabricanteId()));
            entity.setTipo(tipoMedicamentoRepository.buscarPorId(request.getTipoId()));
            entity.setUbicacion(ubicacionRepository.buscarPorId(request.getUbicacionId()));
            entity.setEstado(request.getEstado());

            entity = medicamentoRepository.save(entity);

            if (Objects.nonNull(entity.getId())) {
                response.setMedicamentoEntity(entity);
                response.setRespuesta(new RespuestaType(TipoMensaje.OK));
            } else {
                response.setRespuesta(new RespuestaType(TipoMensaje.ERROR_ACTUALIZANDO_DATOS));
            }

        } else {
            entity = new MedicamentoEntity();
            entity.setNombre(request.getNombre());
            entity.setDescripcion(request.getDescripcion());
            entity.setDosis(request.getDosis());
            entity.setFabricante(laboratorioFabricanteRepository.buscarPorId(request.getFabricanteId()));
            entity.setTipo(tipoMedicamentoRepository.buscarPorId(request.getTipoId()));
            entity.setUbicacion(ubicacionRepository.buscarPorId(request.getUbicacionId()));

            entity = medicamentoRepository.save(entity);

            if (Objects.nonNull(entity.getId())) {
                response.setMedicamentoEntity(entity);
                response.setRespuesta(new RespuestaType(TipoMensaje.OK));
            } else {
                response.setRespuesta(new RespuestaType(TipoMensaje.ERROR_INSERTANDO_DATOS));
            }
        }

        return response;
    }

    @Override
    public MedicamentoResponse buscarPorId(Long id) {
        MedicamentoResponse response = new MedicamentoResponse();
        MedicamentoEntity entity = medicamentoRepository.buscarPorId(id);

        if (Objects.nonNull(entity)) {
            response.setMedicamentoEntity(entity);
            response.setRespuesta(new RespuestaType(TipoMensaje.OK));
        } else {
            response.setRespuesta(new RespuestaType(TipoMensaje.NO_SE_ENCONTRARON_DATOS));
        }

        return response;
    }

    @Override
    public ListadoMedicamentoResponse obtenerListado() {
        ListadoMedicamentoResponse response = new ListadoMedicamentoResponse();
        List<MedicamentoEntity> entityList = medicamentoRepository.obtenerListado();

        if (Objects.nonNull(entityList) && !entityList.isEmpty()) {
            response.setMedicamentoEntityList(entityList);
            response.setRespuesta(new RespuestaType(TipoMensaje.OK));
        } else {
            response.setRespuesta(new RespuestaType(TipoMensaje.NO_SE_ENCONTRARON_DATOS));
        }

        return response;
    }
}
