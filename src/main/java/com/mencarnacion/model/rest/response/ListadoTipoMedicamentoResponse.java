package com.mencarnacion.model.rest.response;

import com.mencarnacion.model.entities.TipoMedicamentoEntity;

import java.util.List;

/**
 * Created by mencarnacion on 9/4/18.
 */
public class ListadoTipoMedicamentoResponse {

    private RespuestaType respuesta;
    private List<TipoMedicamentoEntity> tiposMedicamentos;

    public ListadoTipoMedicamentoResponse() {
        super();
    }

    public ListadoTipoMedicamentoResponse(RespuestaType respuesta) {
        this.respuesta = respuesta;
    }

    public ListadoTipoMedicamentoResponse(RespuestaType respuesta, List<TipoMedicamentoEntity> tiposMedicamentos) {
        this.respuesta = respuesta;
        this.tiposMedicamentos = tiposMedicamentos;
    }

    public RespuestaType getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(RespuestaType respuesta) {
        this.respuesta = respuesta;
    }

    public List<TipoMedicamentoEntity> getTipoMedicamentos() {
        return tiposMedicamentos;
    }

    public void setTipoMedicamentos(List<TipoMedicamentoEntity> tiposMedicamentos) {
        for (TipoMedicamentoEntity tipoMedicamentoEntity : tiposMedicamentos) {
            tipoMedicamentoEntity.setMedicamentos(null);
        }
        this.tiposMedicamentos = tiposMedicamentos;
    }
}
