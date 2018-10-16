package com.mencarnacion.model.rest.response;

import com.mencarnacion.model.dto.RegistroVisitaDTO;
import com.mencarnacion.model.entities.RegistroVisitaEntity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mencarnacion on 9/4/18.
 */
public class ListadoRegistroVisitaResponse {

    private RespuestaType respuesta;
    private List<RegistroVisitaDTO> registrosVisitas;

    public ListadoRegistroVisitaResponse() {
        super();
    }

    public ListadoRegistroVisitaResponse(RespuestaType respuesta) {
        this.respuesta = respuesta;
    }

    public ListadoRegistroVisitaResponse(RespuestaType respuesta, List<RegistroVisitaDTO> registroVisitaEntityList) {
        this.respuesta = respuesta;
        this.registrosVisitas = registroVisitaEntityList;
    }

    public List<RegistroVisitaDTO> covertirEntityToDTO(List<RegistroVisitaEntity> registroVisitaEntities){
        List<RegistroVisitaDTO> registrosVisitasTmp = new ArrayList<>();
        for (RegistroVisitaEntity registroVisita : registroVisitaEntities){
            registrosVisitasTmp.add(new RegistroVisitaDTO(registroVisita));
        }

        return registrosVisitasTmp;
    }

    public RespuestaType getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(RespuestaType respuesta) {
        this.respuesta = respuesta;
    }

    public List<RegistroVisitaDTO> getRegistrosVisitas() {
        return registrosVisitas;
    }

    public void setRegistrosVisitas(List<RegistroVisitaDTO> registrosVisitas) {
        this.registrosVisitas = registrosVisitas;
    }
}
