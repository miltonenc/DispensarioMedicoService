package com.mencarnacion.model.rest.response;

import com.mencarnacion.model.entities.TipoMedicamentoEntity;

/**
 * Created by mencarnacion on 9/4/18.
 */
public class TipoMedicamentoResponse {

    private RespuestaType respuesta;
    private TipoMedicamentoEntity tipoMedicamento;

    public TipoMedicamentoResponse() {
        super();
    }

    public TipoMedicamentoResponse(RespuestaType respuesta) {
        this.respuesta = respuesta;
    }

    public TipoMedicamentoResponse(RespuestaType respuesta, TipoMedicamentoEntity tipoMedicamento) {
        this.respuesta = respuesta;
        this.tipoMedicamento = tipoMedicamento;
    }

    public RespuestaType getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(RespuestaType respuesta) {
        this.respuesta = respuesta;
    }

    public TipoMedicamentoEntity getTipoMedicamento() {
        return tipoMedicamento;
    }

    public void setTipoMedicamento(TipoMedicamentoEntity tipoMedicamento) {
        tipoMedicamento.setMedicamentos(null);
        this.tipoMedicamento = tipoMedicamento;
    }
}
