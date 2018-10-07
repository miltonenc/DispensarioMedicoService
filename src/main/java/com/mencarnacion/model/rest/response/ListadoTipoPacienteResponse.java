package com.mencarnacion.model.rest.response;

import com.mencarnacion.model.entities.TipoPacienteEntity;

import java.util.List;

/**
 * Created by mencarnacion on 9/4/18.
 */
public class ListadoTipoPacienteResponse {

    private RespuestaType respuesta;
    private List<TipoPacienteEntity> tipoPacienteEntityList;

    public ListadoTipoPacienteResponse() {
        super();
    }

    public ListadoTipoPacienteResponse(RespuestaType respuesta) {
        this.respuesta = respuesta;
    }

    public ListadoTipoPacienteResponse(RespuestaType respuesta, List<TipoPacienteEntity> tipoPacienteEntityList) {
        this.respuesta = respuesta;
        this.tipoPacienteEntityList = tipoPacienteEntityList;
    }

    public RespuestaType getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(RespuestaType respuesta) {
        this.respuesta = respuesta;
    }

    public List<TipoPacienteEntity> getTipoPacienteEntityList() {
        return tipoPacienteEntityList;
    }

    public void setTipoPacienteEntityList(List<TipoPacienteEntity> tipoPacienteEntityList) {
        this.tipoPacienteEntityList = tipoPacienteEntityList;
    }
}
