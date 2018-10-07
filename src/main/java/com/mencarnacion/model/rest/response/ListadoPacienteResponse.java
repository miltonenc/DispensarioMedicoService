package com.mencarnacion.model.rest.response;

import com.mencarnacion.model.entities.PacienteEntity;

import java.util.List;

/**
 * Created by mencarnacion on 9/4/18.
 */
public class ListadoPacienteResponse {

    private RespuestaType respuesta;
    private List<PacienteEntity> pacienteEntityList;

    public ListadoPacienteResponse() {
        super();
    }

    public ListadoPacienteResponse(RespuestaType respuesta) {
        this.respuesta = respuesta;
    }

    public ListadoPacienteResponse(RespuestaType respuesta, List<PacienteEntity> pacienteEntityList) {
        this.respuesta = respuesta;
        this.pacienteEntityList = pacienteEntityList;
    }

    public RespuestaType getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(RespuestaType respuesta) {
        this.respuesta = respuesta;
    }

    public List<PacienteEntity> getPacienteEntityList() {
        return pacienteEntityList;
    }

    public void setPacienteEntityList(List<PacienteEntity> pacienteEntityList) {
        this.pacienteEntityList = pacienteEntityList;
    }
}
