package com.mencarnacion.model.rest.response;

import com.mencarnacion.model.entities.MedicoEntity;

import java.util.List;

/**
 * Created by mencarnacion on 9/4/18.
 */
public class ListadoMedicoResponse {

    private RespuestaType respuesta;
    private List<MedicoEntity> medicos;

    public ListadoMedicoResponse() {
        super();
    }

    public ListadoMedicoResponse(RespuestaType respuesta) {
        this.respuesta = respuesta;
    }

    public ListadoMedicoResponse(RespuestaType respuesta, List<MedicoEntity> medicoEntityList) {
        this.respuesta = respuesta;
        this.medicos = medicoEntityList;
    }

    public RespuestaType getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(RespuestaType respuesta) {
        this.respuesta = respuesta;
    }

    public List<MedicoEntity> getMedicos() {
        return medicos;
    }

    public void setMedicos(List<MedicoEntity> medicos) {
        for (MedicoEntity medicoEntity : medicos) {
            medicoEntity.getPersona().setMedicos(null);
            medicoEntity.getPersona().setPacientes(null);
            medicoEntity.getEspecialidad().setMedicos(null);
            medicoEntity.setRegistrosVisitas(null);
            medicoEntity.getUsuario().setPacientes(null);
            medicoEntity.getUsuario().setMedicos(null);
            medicoEntity.getUsuario().setRoles(null);
        }
        this.medicos = medicos;
    }
}
