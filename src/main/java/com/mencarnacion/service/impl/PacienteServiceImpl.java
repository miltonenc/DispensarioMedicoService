package com.mencarnacion.service.impl;

import com.mencarnacion.model.entities.*;
import com.mencarnacion.model.rest.request.PacienteRequest;
import com.mencarnacion.model.rest.response.ListadoPacienteResponse;
import com.mencarnacion.model.rest.response.PacienteResponse;
import com.mencarnacion.model.rest.response.RespuestaType;
import com.mencarnacion.repository.*;
import com.mencarnacion.service.PacienteService;
import com.mencarnacion.util.Rol;
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

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    RolRepository rolRepository;

    @Autowired
    UsuarioRolRepository usuarioRolRepository;

    @Override
    public PacienteResponse guardar(PacienteRequest request) {
        PacienteResponse response = new PacienteResponse();
        PacienteEntity entity = pacienteRepository.buscarPorId(Objects.nonNull(request.getId()) ? request.getId() : null);

        boolean isExisteRegistro = (Objects.nonNull(entity) && Objects.nonNull(entity.getPersona().getId())) ?
                personaRepository.isExisteRegistroPorId(request.getDni().trim(), entity.getPersona().getId()) :
                personaRepository.isExisteRegistro(request.getDni().trim());

        if (isExisteRegistro) {
            response.setRespuesta(new RespuestaType(TipoMensaje.ERROR_DATOS_DUPLICADOS));
            return response;
        }


        if (Objects.nonNull(entity)) {
            entity.getPersona().setNombre(request.getNombre());
            entity.getPersona().setApellido(request.getApellido());
            entity.getPersona().setDni(request.getDni());
            entity.setTipo(tipoPacienteRepository.buscarPorId(request.getTipoId()));
            entity.setEstado(request.getEstado());

            entity = pacienteRepository.save(entity);

            if (Objects.nonNull(entity.getId())) {
                response.setPaciente(entity);
                response.setRespuesta(new RespuestaType(TipoMensaje.OK));
            } else {
                response.setRespuesta(new RespuestaType(TipoMensaje.ERROR_ACTUALIZANDO_DATOS));
            }

        } else {
            entity = new PacienteEntity();
            PersonaEntity personaEntity = new PersonaEntity();
            UsuarioEntity usuarioEntity = new UsuarioEntity(request.getUsuario().trim(), request.getPassword().trim());
            RolEntity rolEntity = rolRepository.buscarPorId(obtenerRolByTipoPaciente(request.getTipoId()));
            UsuarioRolEntity usuarioRolEntity = new UsuarioRolEntity(usuarioEntity, rolEntity);
            entity.setUsuario(usuarioEntity);
            entity.setPersona(personaEntity);
            entity.getPersona().setNombre(request.getNombre());
            entity.getPersona().setApellido(request.getApellido());
            entity.getPersona().setDni(request.getDni());
            entity.setTipo(tipoPacienteRepository.buscarPorId(request.getTipoId()));

            usuarioEntity = usuarioRepository.save(usuarioEntity);
            usuarioRolEntity = usuarioRolRepository.save(usuarioRolEntity);
            personaEntity = personaRepository.save(personaEntity);

            if (Objects.nonNull(usuarioEntity.getId()) && Objects.nonNull(usuarioRolEntity.getId())
                    && Objects.nonNull(personaEntity.getId())) {
                entity = pacienteRepository.save(entity);

                if (Objects.nonNull(entity.getId())) {
                    response.setPaciente(entity);
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

    private Long obtenerRolByTipoPaciente(final Long tipoPaciente) {
        switch (tipoPaciente.intValue()) {
            case 1:
                return Rol.EMPLEADO.getId();
            case 2:
                return Rol.ESTUDIANTE.getId();
            case 3:
                return Rol.PROFESOR.getId();
            default:
                return Rol.ESTUDIANTE.getId();
        }
    }

    @Override
    public PacienteResponse buscarPorId(Long id) {
        PacienteResponse response = new PacienteResponse();
        PacienteEntity entity = pacienteRepository.buscarPorId(id);

        if (Objects.nonNull(entity)) {
            response.setPaciente(entity);
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
            response.setPacientes(entityList);
            response.setRespuesta(new RespuestaType(TipoMensaje.OK));
        } else {
            response.setRespuesta(new RespuestaType(TipoMensaje.NO_SE_ENCONTRARON_DATOS));
        }

        return response;
    }
}
