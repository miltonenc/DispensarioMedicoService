package com.mencarnacion.model.rest.response;

import com.mencarnacion.model.entities.LaboratorioFabricanteEntity;
import com.mencarnacion.model.entities.MedicamentoEntity;

import java.util.List;

/**
 * Created by mencarnacion on 9/4/18.
 */
public class ListadoLaboratorioFabricanteResponse {

    private RespuestaType respuesta;
    private List<LaboratorioFabricanteEntity> laboratorioFabricantes;

    public ListadoLaboratorioFabricanteResponse() {
        super();
    }

    public ListadoLaboratorioFabricanteResponse(RespuestaType respuesta) {
        this.respuesta = respuesta;
    }

    public ListadoLaboratorioFabricanteResponse(RespuestaType respuesta, List<LaboratorioFabricanteEntity> laboratorioFabricantes) {
        this.respuesta = respuesta;
        this.laboratorioFabricantes = laboratorioFabricantes;
    }

    public RespuestaType getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(RespuestaType respuesta) {
        this.respuesta = respuesta;
    }

    public List<LaboratorioFabricanteEntity> getLaboratorioFabricantes() {
        return laboratorioFabricantes;
    }

    public void setLaboratorioFabricantes(List<LaboratorioFabricanteEntity> laboratorioFabricantes) {
        for (LaboratorioFabricanteEntity laboratorioFabricante : laboratorioFabricantes) {
            for (MedicamentoEntity medicamentoEntity : laboratorioFabricante.getMedicamentos()) {
                medicamentoEntity.setRegistrosVisitas(null);
                medicamentoEntity.setFabricante(null);
                medicamentoEntity.getTipo().setMedicamentos(null);
                medicamentoEntity.getUbicacion().setMedicamentos(null);
            }
        }
        this.laboratorioFabricantes = laboratorioFabricantes;
    }
}
