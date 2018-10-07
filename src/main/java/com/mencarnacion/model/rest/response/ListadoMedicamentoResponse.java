package com.mencarnacion.model.rest.response;

import com.mencarnacion.model.entities.MedicamentoEntity;

import java.util.List;

/**
 * Created by mencarnacion on 9/4/18.
 */
public class ListadoMedicamentoResponse {

    private RespuestaType respuesta;
    private List<MedicamentoEntity> medicamentoEntityList;

    public ListadoMedicamentoResponse() {
        super();
    }

    public ListadoMedicamentoResponse(RespuestaType respuesta) {
        this.respuesta = respuesta;
    }

    public ListadoMedicamentoResponse(RespuestaType respuesta, List<MedicamentoEntity> tipoPacienteEntityList) {
        this.respuesta = respuesta;
        this.medicamentoEntityList = tipoPacienteEntityList;
    }

    public RespuestaType getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(RespuestaType respuesta) {
        this.respuesta = respuesta;
    }

    public List<MedicamentoEntity> getMedicamentoEntityList() {
        return medicamentoEntityList;
    }

    public void setMedicamentoEntityList(List<MedicamentoEntity> tipoPacienteEntityList) {
        this.medicamentoEntityList = tipoPacienteEntityList;
    }
}
