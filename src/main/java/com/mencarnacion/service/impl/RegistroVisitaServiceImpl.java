package com.mencarnacion.service.impl;

import com.mencarnacion.model.dto.RegistroVisitaDTO;
import com.mencarnacion.model.entities.RegistroVisitaEntity;
import com.mencarnacion.model.rest.request.RegistroVisitaRequest;
import com.mencarnacion.model.rest.response.ListadoRegistroVisitaResponse;
import com.mencarnacion.model.rest.response.RegistroVisitaResponse;
import com.mencarnacion.model.rest.response.RespuestaType;
import com.mencarnacion.repository.MedicamentoRepository;
import com.mencarnacion.repository.MedicoRepository;
import com.mencarnacion.repository.PacienteRepository;
import com.mencarnacion.repository.RegistroVisitaRepository;
import com.mencarnacion.service.RegistroVisitaService;
import com.mencarnacion.util.TipoMensaje;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * Created by mencarnacion on 8/28/18.
 */
@Service
public class RegistroVisitaServiceImpl implements RegistroVisitaService {

    @Autowired
    RegistroVisitaRepository registroVisitaRepository;

    @Autowired
    PacienteRepository pacienteRepository;

    @Autowired
    MedicamentoRepository medicamentoRepository;

    @Autowired
    MedicoRepository medicoRepository;

    @Override
    public RegistroVisitaResponse guardar(RegistroVisitaRequest request) {
        RegistroVisitaResponse response = new RegistroVisitaResponse();
        RegistroVisitaEntity entity = new RegistroVisitaEntity();

        entity.setSintoma(request.getSintoma());
        entity.setRecomendacion(request.getRecomendacion());
        entity.setPaciente(pacienteRepository.buscarPorId(request.getPacienteId()));
        entity.setMedicamento(medicamentoRepository.buscarPorId(request.getMedicamentoId()));
        entity.setMedico(medicoRepository.buscarPorId(request.getMedicoId()));

        entity = registroVisitaRepository.save(entity);

        if (Objects.nonNull(entity.getId())) {
            response.setRegistroVisita(new RegistroVisitaDTO(entity));
            response.setRespuesta(new RespuestaType(TipoMensaje.OK));
        } else {
            response.setRespuesta(new RespuestaType(TipoMensaje.ERROR_INSERTANDO_DATOS));
        }

        return response;
    }

    @Override
    public RegistroVisitaResponse buscarPorId(Long id) {
        RegistroVisitaResponse response = new RegistroVisitaResponse();
        RegistroVisitaEntity entity = registroVisitaRepository.buscarPorId(id);

        if (Objects.nonNull(entity)) {
            response.setRegistroVisita(new RegistroVisitaDTO(entity));
            response.setRespuesta(new RespuestaType(TipoMensaje.OK));
        } else {
            response.setRespuesta(new RespuestaType(TipoMensaje.NO_SE_ENCONTRARON_DATOS));
        }

        return response;
    }

    @Override
    public ListadoRegistroVisitaResponse obtenerListado() {
        ListadoRegistroVisitaResponse response = new ListadoRegistroVisitaResponse();
        List<RegistroVisitaEntity> entityList = registroVisitaRepository.obtenerListado();

        if (Objects.nonNull(entityList) && !entityList.isEmpty()) {
            response.setRegistrosVisitas(response.covertirEntityToDTO(entityList));
            response.setRespuesta(new RespuestaType(TipoMensaje.OK));
        } else {
            response.setRespuesta(new RespuestaType(TipoMensaje.NO_SE_ENCONTRARON_DATOS));
        }

        return response;
    }


    @Override
    public ListadoRegistroVisitaResponse obtenerListadoPorMedico(Long medicoId) {
        ListadoRegistroVisitaResponse response = new ListadoRegistroVisitaResponse();
        List<RegistroVisitaEntity> entityList = registroVisitaRepository.obtenerListadoPorMedico(medicoId);

        if (Objects.nonNull(entityList) && !entityList.isEmpty()) {
            response.setRegistrosVisitas(response.covertirEntityToDTO(entityList));
            response.setRespuesta(new RespuestaType(TipoMensaje.OK));
        } else {
            response.setRespuesta(new RespuestaType(TipoMensaje.NO_SE_ENCONTRARON_DATOS));
        }

        return response;
    }

    @Override
    public ListadoRegistroVisitaResponse obtenerListadoPorPaciente(Long pacienteId) {
        ListadoRegistroVisitaResponse response = new ListadoRegistroVisitaResponse();
        List<RegistroVisitaEntity> entityList = registroVisitaRepository.obtenerListadoPorPaciente(pacienteId);

        if (Objects.nonNull(entityList) && !entityList.isEmpty()) {
            response.setRegistrosVisitas(response.covertirEntityToDTO(entityList));
            response.setRespuesta(new RespuestaType(TipoMensaje.OK));
        } else {
            response.setRespuesta(new RespuestaType(TipoMensaje.NO_SE_ENCONTRARON_DATOS));
        }

        return response;
    }
}
