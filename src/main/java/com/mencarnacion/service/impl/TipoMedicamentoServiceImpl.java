package com.mencarnacion.service.impl;

import com.mencarnacion.model.entities.TipoMedicamentoEntity;
import com.mencarnacion.model.rest.request.TipoMedicamentoRequest;
import com.mencarnacion.model.rest.response.ListadoTipoMedicamentoResponse;
import com.mencarnacion.model.rest.response.RespuestaType;
import com.mencarnacion.model.rest.response.TipoMedicamentoResponse;
import com.mencarnacion.repository.TipoMedicamentoRepository;
import com.mencarnacion.service.TipoMedicamentoService;
import com.mencarnacion.util.TipoMensaje;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * Created by mencarnacion on 8/28/18.
 */
@Service
public class TipoMedicamentoServiceImpl implements TipoMedicamentoService {

    private static final Logger log = LoggerFactory.getLogger(TipoMedicamentoServiceImpl.class);

    @Autowired
    TipoMedicamentoRepository tipoMedicamentoRepository;

    @Override
    public TipoMedicamentoResponse guardar(TipoMedicamentoRequest request) {
        TipoMedicamentoResponse response = new TipoMedicamentoResponse();

        boolean isExisteRegistro = Objects.nonNull(request.getId()) ?
                tipoMedicamentoRepository.isExisteRegistroPorId(request.getNombre().trim(), request.getId()) :
                tipoMedicamentoRepository.isExisteRegistro(request.getNombre().trim());

        if(isExisteRegistro){
            response.setRespuesta(new RespuestaType(TipoMensaje.ERROR_DATOS_DUPLICADOS));
            return response;
        }

        TipoMedicamentoEntity entity = tipoMedicamentoRepository.buscarPorId(Objects.nonNull(request.getId()) ? request.getId() : null);

        if (Objects.nonNull(entity)) {
            entity.setNombre(request.getNombre());
            entity.setDescripcion(request.getDescripcion());
            entity.setEstado(request.getEstado());

            entity = tipoMedicamentoRepository.save(entity);

            if (Objects.nonNull(entity.getId())) {
                response.setTipoMedicamento(entity);
                response.setRespuesta(new RespuestaType(TipoMensaje.OK));
            } else {
                response.setRespuesta(new RespuestaType(TipoMensaje.ERROR_ACTUALIZANDO_DATOS));
            }

        } else {
            entity = new TipoMedicamentoEntity();
            entity.setNombre(request.getNombre());
            entity.setDescripcion(request.getDescripcion());

            entity = tipoMedicamentoRepository.save(entity);

            if (Objects.nonNull(entity.getId())) {
                response.setTipoMedicamento(entity);
                response.setRespuesta(new RespuestaType(TipoMensaje.OK));
            } else {
                response.setRespuesta(new RespuestaType(TipoMensaje.ERROR_INSERTANDO_DATOS));
            }
        }

        return response;
    }

    @Override
    public TipoMedicamentoResponse buscarPorId(Long id) {
        TipoMedicamentoResponse response = new TipoMedicamentoResponse();
        TipoMedicamentoEntity tipoMedicamento = tipoMedicamentoRepository.buscarPorId(id);

        if (Objects.nonNull(tipoMedicamento)) {
            response.setTipoMedicamento(tipoMedicamento);
            response.setRespuesta(new RespuestaType(TipoMensaje.OK));
        } else {
            response.setRespuesta(new RespuestaType(TipoMensaje.NO_SE_ENCONTRARON_DATOS));
        }

        return response;
    }

    @Override
    public ListadoTipoMedicamentoResponse obtenerListado() {
        ListadoTipoMedicamentoResponse response = new ListadoTipoMedicamentoResponse();
        List<TipoMedicamentoEntity> tipoMedicamentoList = tipoMedicamentoRepository.obtenerListado();

        if (Objects.nonNull(tipoMedicamentoList) && !tipoMedicamentoList.isEmpty()) {
            response.setTipoMedicamentos(tipoMedicamentoList);
            response.setRespuesta(new RespuestaType(TipoMensaje.OK));
        } else {
            response.setRespuesta(new RespuestaType(TipoMensaje.NO_SE_ENCONTRARON_DATOS));
        }

        return response;
    }
}
