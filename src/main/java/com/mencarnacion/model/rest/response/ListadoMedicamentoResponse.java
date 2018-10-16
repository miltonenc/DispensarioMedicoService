package com.mencarnacion.model.rest.response;

import com.mencarnacion.model.dto.MedicamentoDTO;
import com.mencarnacion.model.entities.MedicamentoEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mencarnacion on 9/4/18.
 */
public class ListadoMedicamentoResponse {

    private RespuestaType respuesta;
    private List<MedicamentoDTO> medicamentos;

    public ListadoMedicamentoResponse() {
        super();
    }

    public ListadoMedicamentoResponse(RespuestaType respuesta) {
        this.respuesta = respuesta;
    }

    public ListadoMedicamentoResponse(RespuestaType respuesta, List<MedicamentoDTO> tipoPacienteEntityList) {
        this.respuesta = respuesta;
        this.medicamentos = tipoPacienteEntityList;
    }

    public RespuestaType getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(RespuestaType respuesta) {
        this.respuesta = respuesta;
    }

    public List<MedicamentoDTO> getMedicamentos() {
        return medicamentos;
    }

    public void setMedicamentos(List<MedicamentoDTO> tipoPacienteEntityList) {
        this.medicamentos = tipoPacienteEntityList;
    }

    public List<MedicamentoDTO> convertEntityToDTO(List<MedicamentoEntity> medicamentoEntities) {
        List<MedicamentoDTO> medicamentoTmp = new ArrayList<>();
        for (MedicamentoEntity medicamentoEntity : medicamentoEntities) {
            medicamentoTmp.add(new MedicamentoDTO(medicamentoEntity));
        }

        return medicamentoTmp;
    }
}
