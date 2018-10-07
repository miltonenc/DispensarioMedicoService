package com.mencarnacion.service.impl;

import com.mencarnacion.model.entities.PacienteEntity;
import com.mencarnacion.model.entities.PersonaEntity;
import com.mencarnacion.model.rest.request.PacienteRequest;
import com.mencarnacion.model.rest.response.ListadoPacienteResponse;
import com.mencarnacion.model.rest.response.PacienteResponse;
import com.mencarnacion.model.rest.response.RespuestaType;
import com.mencarnacion.repository.PacienteRepository;
import com.mencarnacion.repository.PersonaRepository;
import com.mencarnacion.repository.TipoPacienteRepository;
import com.mencarnacion.service.PacienteService;
import com.mencarnacion.util.TipoMensaje;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * Created by mencarnacion on 8/28/18.
 */
@Service
public class PacienteServiceImpl implements PacienteService {

    @Autowired
    PacienteRepository pacienteRepository;

    @Autowired
    PersonaRepository personaRepository;

    @Autowired
    TipoPacienteRepository tipoPacienteRepository;

    @Override
    public PacienteResponse guardar(PacienteRequest request) {
        PacienteResponse response = new PacienteResponse();
        PacienteEntity entity = pacienteRepository.buscarPorId(Objects.nonNull(request.getId()) ? request.getId() : null);

        if (Objects.nonNull(entity)) {
            entity.getPersona().setNombre(request.getNombre());
            entity.getPersona().setApellido(request.getApellido());
            entity.getPersona().setDni(request.getDni());
            entity.setTipo(tipoPacienteRepository.buscarPorId(request.getTipoId()));
            entity.setEstado(request.getEstado());

            entity = pacienteRepository.save(entity);

            if (Objects.nonNull(entity.getId())) {
                response.setPacienteEntity(entity);
                response.setRespuesta(new RespuestaType(TipoMensaje.OK));
            } else {
                response.setRespuesta(new RespuestaType(TipoMensaje.ERROR_ACTUALIZANDO_DATOS));
            }

        } else {
            entity = new PacienteEntity();
            PersonaEntity personaEntity = new PersonaEntity();
            entity.setPersona(personaEntity);
            entity.getPersona().setNombre(request.getNombre());
            entity.getPersona().setApellido(request.getApellido());
            entity.getPersona().setDni(request.getDni());
            entity.setTipo(tipoPacienteRepository.buscarPorId(request.getTipoId()));

            personaEntity = personaRepository.save(personaEntity);
            if (Objects.nonNull(personaEntity.getId())) {
                entity = pacienteRepository.save(entity);

                if (Objects.nonNull(entity.getId())) {
                    response.setPacienteEntity(entity);
                    response.setRespuesta(new RespuestaType(TipoMensaje.OK));
                } else {
                    response.setRespuesta(new RespuestaType(TipoMensaje.ERROR_INSERTANDO_DATOS));
                }
            } else {
                response.setRespuesta(new RespuestaType(TipoMensaje.ERROR_INSERTANDO_DATOS));
            }

        }

        return response;
    }

    @Override
    public PacienteResponse buscarPorId(Long id) {
        PacienteResponse response = new PacienteResponse();
        PacienteEntity entity = pacienteRepository.buscarPorId(id);

        if (Objects.nonNull(entity)) {
            response.setPacienteEntity(entity);
            response.setRespuesta(new RespuestaType(TipoMensaje.OK));
        } else {
            response.setRespuesta(new RespuestaType(TipoMensaje.NO_SE_ENCONTRARON_DATOS));
        }

        return response;
    }

    @Override
    public ListadoPacienteResponse obtenerListado() {
        ListadoPacienteResponse response = new ListadoPacienteResponse();
        List<PacienteEntity> entityList = pacienteRepository.obtenerListado();

        if (Objects.nonNull(entityList) && !entityList.isEmpty()) {
            response.setPacienteEntityList(entityList);
            response.setRespuesta(new RespuestaType(TipoMensaje.OK));
        } else {
            response.setRespuesta(new RespuestaType(TipoMensaje.NO_SE_ENCONTRARON_DATOS));
        }

        return response;
    }
}
