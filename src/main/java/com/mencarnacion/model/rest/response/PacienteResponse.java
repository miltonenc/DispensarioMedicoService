package com.mencarnacion.model.rest.response;

import com.mencarnacion.model.entities.PacienteEntity;

/**
 * Created by mencarnacion on 9/4/18.
 */
public class PacienteResponse {

    private RespuestaType respuesta;
    private PacienteEntity paciente;

    public PacienteResponse() {
        super();
    }

    public PacienteResponse(RespuestaType respuesta) {
        this.respuesta = respuesta;
    }

    public PacienteResponse(RespuestaType respuesta, PacienteEntity pacienteEntity) {
        this.respuesta = respuesta;
        this.paciente = pacienteEntity;
    }

    public RespuestaType getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(RespuestaType respuesta) {
        this.respuesta = respuesta;
    }

    public PacienteEntity getPaciente() {
        return paciente;
    }

    public void setPaciente(PacienteEntity paciente) {
        paciente.getPersona().setMedicos(null);
        paciente.getPersona().setPacientes(null);
        paciente.getTipo().setPacientes(null);
        paciente.setRegistrosVisitas(null);
        paciente.getUsuario().setPacientes(null);
        paciente.getUsuario().setMedicos(null);
        paciente.getUsuario().setRoles(null);
        this.paciente = paciente;
    }
}
