package com.mencarnacion.service.impl;

import com.mencarnacion.model.entities.*;
import com.mencarnacion.model.rest.request.MedicoRequest;
import com.mencarnacion.model.rest.response.ListadoMedicoResponse;
import com.mencarnacion.model.rest.response.MedicoResponse;
import com.mencarnacion.model.rest.response.RespuestaType;
import com.mencarnacion.repository.*;
import com.mencarnacion.service.MedicoService;
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
public class MedicoServiceImpl implements MedicoService {

    @Autowired
    MedicoRepository medicoRepository;

    @Autowired
    PersonaRepository personaRepository;

    @Autowired
    MedicoEspecialidadRepository medicoEspecialidadRepository;

    @Autowired
    UsuarioRepository usuarioRepository;

    @Autowired
    RolRepository rolRepository;

    @Autowired
    UsuarioRolRepository usuarioRolRepository;

    @Override
    public MedicoResponse guardar(MedicoRequest request) {
        MedicoResponse response = new MedicoResponse();

        MedicoEntity entity = medicoRepository.buscarPorId(Objects.nonNull(request.getId()) ? request.getId() : null);

        boolean isExisteRegistro;
        if (Objects.nonNull(entity) && Objects.nonNull(entity.getPersona().getId())) {
            isExisteRegistro = personaRepository.isExisteRegistroPorId(request.getDni().trim(), entity.getPersona().getId());
        } else {
            isExisteRegistro = personaRepository.isExisteRegistro(request.getDni().trim());
        }

        if (isExisteRegistro) {
            response.setRespuesta(new RespuestaType(TipoMensaje.ERROR_DATOS_DUPLICADOS));
            return response;
        }


        if (Objects.nonNull(entity)) {
            entity.getPersona().setNombre(request.getNombre());
            entity.getPersona().setApellido(request.getApellido());
            entity.getPersona().setDni(request.getDni());
            entity.setTandaLabor(request.getTandaLabor());
            entity.setEspecialidad(medicoEspecialidadRepository.buscarPorId(request.getEspecialidadId()));
            entity.setEstado(request.getEstado());

            entity = medicoRepository.save(entity);

            if (Objects.nonNull(entity.getId())) {
                response.setMedico(entity);
                response.setRespuesta(new RespuestaType(TipoMensaje.OK));
            } else {
                response.setRespuesta(new RespuestaType(TipoMensaje.ERROR_ACTUALIZANDO_DATOS));
            }

        } else {
            entity = new MedicoEntity();
            PersonaEntity personaEntity = new PersonaEntity();
            UsuarioEntity usuarioEntity = new UsuarioEntity(request.getUsuario().trim(), request.getPassword().trim());
            RolEntity rolEntity = rolRepository.buscarPorId(Rol.MEDICO.getId());
            UsuarioRolEntity usuarioRolEntity = new UsuarioRolEntity(usuarioEntity, rolEntity);
            entity.setUsuario(usuarioEntity);
            entity.setPersona(personaEntity);
            entity.getPersona().setNombre(request.getNombre());
            entity.getPersona().setApellido(request.getApellido());
            entity.getPersona().setDni(request.getDni());
            entity.setTandaLabor(request.getTandaLabor());
            entity.setEspecialidad(medicoEspecialidadRepository.buscarPorId(request.getEspecialidadId()));

            usuarioEntity = usuarioRepository.save(usuarioEntity);
            usuarioRolEntity = usuarioRolRepository.save(usuarioRolEntity);
            personaEntity = personaRepository.save(personaEntity);

            if (Objects.nonNull(usuarioEntity.getId()) && Objects.nonNull(usuarioRolEntity.getId())
                    && Objects.nonNull(personaEntity.getId())) {
                entity = medicoRepository.save(entity);

                if (Objects.nonNull(entity.getId())) {
                    response.setMedico(entity);
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
            response.setMedico(entity);
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
            response.setMedicos(entityList);
            response.setRespuesta(new RespuestaType(TipoMensaje.OK));
        } else {
            response.setRespuesta(new RespuestaType(TipoMensaje.NO_SE_ENCONTRARON_DATOS));
        }

        return response;
    }
}
