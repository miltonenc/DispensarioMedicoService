package com.mencarnacion.controller;

import com.mencarnacion.model.rest.request.LaboratorioFabricanteRequest;
import com.mencarnacion.model.rest.response.LaboratorioFabricanteResponse;
import com.mencarnacion.model.rest.response.ListadoLaboratorioFabricanteResponse;
import com.mencarnacion.model.rest.response.RespuestaType;
import com.mencarnacion.service.LaboratorioFabricanteService;
import com.mencarnacion.util.ConstantesUtil;
import com.mencarnacion.util.TipoMensaje;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;

/**
 * Created by mencarnacion on 8/28/18.
 */
@RestController
@RequestMapping(ConstantesUtil.API)
public class LaboratorioFabricanteController {

    private static final Logger log = LoggerFactory.getLogger(LaboratorioFabricanteController.class);

    @Autowired
    public LaboratorioFabricanteService laboratorioFabricanteService;

    @RequestMapping(value = ConstantesUtil.LISTADO_LABORATORIO_FABICANTE,
            method = RequestMethod.GET,
            produces = ConstantesUtil.APPLICATION_JSON)
    @CrossOrigin(origins = ConstantesUtil.CROSS_ORIGIN)
    public ListadoLaboratorioFabricanteResponse obtenerListado() {
        try {
            return laboratorioFabricanteService.obtenerListado();
        } catch (Exception e) {
            log.debug(ConstantesUtil.LISTADO_LABORATORIO_FABICANTE);
            log.error(Arrays.toString(e.getStackTrace()));
            return new ListadoLaboratorioFabricanteResponse(new RespuestaType(TipoMensaje.ERROR_INTERNO_SERVICIO));
        }
    }

    @RequestMapping(value = ConstantesUtil.OBTENER_LABORATORIO_FABICANTE,
            method = RequestMethod.GET,
            produces = ConstantesUtil.APPLICATION_JSON)
    @CrossOrigin(origins = ConstantesUtil.CROSS_ORIGIN)
    public LaboratorioFabricanteResponse obtener(@RequestBody Long id) {
        try {
            return laboratorioFabricanteService.buscarPorId(id);
        } catch (Exception e) {
            log.debug(ConstantesUtil.OBTENER_LABORATORIO_FABICANTE);
            log.error(Arrays.toString(e.getStackTrace()));
            return new LaboratorioFabricanteResponse(new RespuestaType(TipoMensaje.ERROR_INTERNO_SERVICIO));
        }
    }

    @RequestMapping(value = ConstantesUtil.GUARDAR_LABORATORIO_FABICANTE,
            method = RequestMethod.POST,
            produces = ConstantesUtil.APPLICATION_JSON)
    @CrossOrigin(origins = ConstantesUtil.CROSS_ORIGIN)
    public LaboratorioFabricanteResponse guardar(@RequestBody LaboratorioFabricanteRequest request) {
        try {
            return laboratorioFabricanteService.guardar(request);
        } catch (Exception e) {
            log.debug(ConstantesUtil.GUARDAR_LABORATORIO_FABICANTE);
            log.error(Arrays.toString(e.getStackTrace()));
            return new LaboratorioFabricanteResponse(new RespuestaType(TipoMensaje.ERROR_INTERNO_SERVICIO));
        }
    }
}
