package com.mencarnacion.model.rest.response;

import com.mencarnacion.model.entities.PacienteEntity;

import java.util.List;

/**
 * Created by mencarnacion on 9/4/18.
 */
public class ListadoPacienteResponse {

    private RespuestaType respuesta;
    private List<PacienteEntity> pacientes;

    public ListadoPacienteResponse() {
        super();
    }

    public ListadoPacienteResponse(RespuestaType respuesta) {
        this.respuesta = respuesta;
    }

    public ListadoPacienteResponse(RespuestaType respuesta, List<PacienteEntity> pacienteEntityList) {
        this.respuesta = respuesta;
        this.pacientes = pacienteEntityList;
    }

    public RespuestaType getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(RespuestaType respuesta) {
        this.respuesta = respuesta;
    }

    public List<PacienteEntity> getPacientes() {
        return pacientes;
    }

    public void setPacientes(List<PacienteEntity> pacientes) {

        for (PacienteEntity paciente : pacientes) {
            paciente.getPersona().setMedicos(null);
            paciente.getPersona().setPacientes(null);
            paciente.getTipo().setPacientes(null);
            paciente.setRegistrosVisitas(null);
            paciente.getUsuario().setPacientes(null);
            paciente.getUsuario().setMedicos(null);
            paciente.getUsuario().setRoles(null);
        }

        this.pacientes = pacientes;
    }
}
