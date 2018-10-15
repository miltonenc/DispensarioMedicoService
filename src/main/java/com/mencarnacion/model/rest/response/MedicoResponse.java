package com.mencarnacion.model.rest.response;

import com.mencarnacion.model.entities.MedicoEntity;

/**
 * Created by mencarnacion on 9/4/18.
 */
public class MedicoResponse {

    private RespuestaType respuesta;
    private MedicoEntity medico;

    public MedicoResponse() {
        super();
    }

    public MedicoResponse(RespuestaType respuesta) {
        this.respuesta = respuesta;
    }

    public MedicoResponse(RespuestaType respuesta, MedicoEntity medicoEntity) {
        this.respuesta = respuesta;
        this.medico = medicoEntity;
    }

    public RespuestaType getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(RespuestaType respuesta) {
        this.respuesta = respuesta;
    }

    public MedicoEntity getMedico() {
        return medico;
    }

    public void setMedico(MedicoEntity medico) {
        medico.getPersona().setMedicos(null);
        medico.getPersona().setPacientes(null);
        medico.getEspecialidad().setMedicos(null);
        medico.setRegistrosVisitas(null);
        medico.getUsuario().setPacientes(null);
        medico.getUsuario().setMedicos(null);
        medico.getUsuario().setRoles(null);
        this.medico = medico;
    }
}
