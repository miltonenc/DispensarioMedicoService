package com.mencarnacion.controller;

import com.mencarnacion.model.rest.request.TipoPacienteRequest;
import com.mencarnacion.model.rest.response.ListadoTipoPacienteResponse;
import com.mencarnacion.model.rest.response.RespuestaType;
import com.mencarnacion.model.rest.response.TipoPacienteResponse;
import com.mencarnacion.service.TipoPacienteService;
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
public class TipoPacienteController {

    private static final Logger log = LoggerFactory.getLogger(TipoPacienteController.class);

    @Autowired
    public TipoPacienteService tipoPacienteService;

    @RequestMapping(value = ConstantesUtil.LISTADO_TIPO_PACIENTE, method = RequestMethod.GET, produces = ConstantesUtil.APPLICATION_JSON)
    @CrossOrigin(origins = ConstantesUtil.CROSS_ORIGIN)
    public ListadoTipoPacienteResponse obtenerListado() {
        try {
            return tipoPacienteService.obtenerListado();
        } catch (Exception e) {
            log.debug(ConstantesUtil.LISTADO_TIPO_PACIENTE);
            log.error(Arrays.toString(e.getStackTrace()));
            return new ListadoTipoPacienteResponse(new RespuestaType(TipoMensaje.ERROR_INTERNO_SERVICIO));
        }
    }

    @RequestMapping(value = ConstantesUtil.OBTENER_TIPO_PACIENTE, method = RequestMethod.GET, produces = ConstantesUtil.APPLICATION_JSON)
    @CrossOrigin(origins = ConstantesUtil.CROSS_ORIGIN)
    public TipoPacienteResponse obtener(Long id) {
        try {
            return tipoPacienteService.buscarPorId(id);
        } catch (Exception e) {
            log.debug(ConstantesUtil.OBTENER_TIPO_PACIENTE);
            log.error(Arrays.toString(e.getStackTrace()));
            return new TipoPacienteResponse(new RespuestaType(TipoMensaje.ERROR_INTERNO_SERVICIO));
        }
    }

    @RequestMapping(value = ConstantesUtil.GUARDAR_TIPO_PACIENTE, method = RequestMethod.POST, produces = ConstantesUtil.APPLICATION_JSON)
    @CrossOrigin(origins = ConstantesUtil.CROSS_ORIGIN)
    public TipoPacienteResponse guardar(@RequestBody TipoPacienteRequest request) {
        try {
            return tipoPacienteService.guardar(request);
        } catch (Exception e) {
            log.debug(ConstantesUtil.GUARDAR_TIPO_PACIENTE);
            log.error(Arrays.toString(e.getStackTrace()));
            return new TipoPacienteResponse(new RespuestaType(TipoMensaje.ERROR_INTERNO_SERVICIO));
        }
    }
}
