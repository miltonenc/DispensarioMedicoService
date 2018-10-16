package com.mencarnacion.model.rest.response;

import com.mencarnacion.model.entities.LaboratorioFabricanteEntity;
import com.mencarnacion.model.entities.MedicamentoEntity;

/**
 * Created by mencarnacion on 9/4/18.
 */
public class LaboratorioFabricanteResponse {

    private RespuestaType respuesta;
    private LaboratorioFabricanteEntity laboratorioFabricante;

    public LaboratorioFabricanteResponse() {
        super();
    }

    public LaboratorioFabricanteResponse(RespuestaType respuesta) {
        this.respuesta = respuesta;
    }

    public LaboratorioFabricanteResponse(RespuestaType respuesta, LaboratorioFabricanteEntity laboratorioFabricante) {
        this.respuesta = respuesta;
        this.laboratorioFabricante = laboratorioFabricante;
    }

    public RespuestaType getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(RespuestaType respuesta) {
        this.respuesta = respuesta;
    }

    public LaboratorioFabricanteEntity getLaboratorioFabricante() {
        return laboratorioFabricante;
    }

    public void setLaboratorioFabricante(LaboratorioFabricanteEntity laboratorioFabricante) {
        for(MedicamentoEntity medicamentoEntity : laboratorioFabricante.getMedicamentos()){
            medicamentoEntity.setFabricante(null);
            medicamentoEntity.setRegistrosVisitas(null);
            medicamentoEntity.getTipo().setMedicamentos(null);
            medicamentoEntity.getUbicacion().setMedicamentos(null);
        }
        this.laboratorioFabricante = laboratorioFabricante;
    }
}
