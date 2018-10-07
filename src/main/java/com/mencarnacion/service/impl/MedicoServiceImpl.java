package com.mencarnacion.service.impl;

import com.mencarnacion.model.entities.MedicoEntity;
import com.mencarnacion.model.entities.PersonaEntity;
import com.mencarnacion.model.rest.request.MedicoRequest;
import com.mencarnacion.model.rest.response.ListadoMedicoResponse;
import com.mencarnacion.model.rest.response.MedicoResponse;
import com.mencarnacion.model.rest.response.RespuestaType;
import com.mencarnacion.repository.MedicoEspecialidadRepository;
import com.mencarnacion.repository.MedicoRepository;
import com.mencarnacion.repository.PersonaRepository;
import com.mencarnacion.service.MedicoService;
import com.mencarnacion.util.TipoMensaje;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

/**
 * Created by mencarnacion on 8/28/18.
 */
@Service
public class MedicoServiceImpl implements MedicoService {

    @Autowired
    MedicoRepository medicoRepository;

    @Autowired
    PersonaRepository personaRepository;

    @Autowired
    MedicoEspecialidadRepository medicoEspecialidadRepository;

    @Override
    public MedicoResponse guardar(MedicoRequest request) {
        MedicoResponse response = new MedicoResponse();
        MedicoEntity entity = medicoRepository.buscarPorId(Objects.nonNull(request.getId()) ? request.getId() : null);

        if (Objects.nonNull(entity)) {
            entity.getPersona().setNombre(request.getNombre());
            entity.getPersona().setApellido(request.getApellido());
            entity.getPersona().setDni(request.getDni());
            entity.setEspecialidad(medicoEspecialidadRepository.buscarPorId(request.getEspecialidadId()));
            entity.setEstado(request.getEstado());

            entity = medicoRepository.save(entity);

            if (Objects.nonNull(entity.getId())) {
                response.setMedicoEntity(entity);
                response.setRespuesta(new RespuestaType(TipoMensaje.OK));
            } else {
                response.setRespuesta(new RespuestaType(TipoMensaje.ERROR_ACTUALIZANDO_DATOS));
            }

        } else {
            entity = new MedicoEntity();
            PersonaEntity personaEntity = new PersonaEntity();
            entity.setPersona(personaEntity);
            entity.getPersona().setNombre(request.getNombre());
            entity.getPersona().setApellido(request.getApellido());
            entity.getPersona().setDni(request.getDni());
            entity.setEspecialidad(medicoEspecialidadRepository.buscarPorId(request.getEspecialidadId()));

            personaEntity = personaRepository.save(personaEntity);
            if (Objects.nonNull(personaEntity.getId())) {
                entity = medicoRepository.save(entity);

                if (Objects.nonNull(entity.getId())) {
                    response.setMedicoEntity(entity);
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
    public MedicoResponse buscarPorId(Long id) {
        MedicoResponse response = new MedicoResponse();
        MedicoEntity entity = medicoRepository.buscarPorId(id);

        if (Objects.nonNull(entity)) {
            response.setMedicoEntity(entity);
            response.setRespuesta(new RespuestaType(TipoMensaje.OK));
        } else {
            response.setRespuesta(new RespuestaType(TipoMensaje.NO_SE_ENCONTRARON_DATOS));
        }

        return response;
    }

    @Override
    public ListadoMedicoResponse obtenerListado() {
        ListadoMedicoResponse response = new ListadoMedicoResponse();
        List<MedicoEntity> entityList = medicoRepository.obtenerListado();

        if (Objects.nonNull(entityList) && !entityList.isEmpty()) {
            response.setMedicoEntityList(entityList);
            response.setRespuesta(new RespuestaType(TipoMensaje.OK));
        } else {
            response.setRespuesta(new RespuestaType(TipoMensaje.NO_SE_ENCONTRARON_DATOS));
        }

        return response;
    }
}
