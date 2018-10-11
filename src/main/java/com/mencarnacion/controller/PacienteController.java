package com.mencarnacion.controller;

import com.mencarnacion.model.rest.request.PacienteRequest;
import com.mencarnacion.model.rest.response.ListadoPacienteResponse;
import com.mencarnacion.model.rest.response.PacienteResponse;
import com.mencarnacion.model.rest.response.RespuestaType;
import com.mencarnacion.service.PacienteService;
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
public class PacienteController {

    private static final Logger log = LoggerFactory.getLogger(PacienteController.class);

    @Autowired
    public PacienteService pacienteService;

    @RequestMapping(value = ConstantesUtil.LISTADO_PACIENTE, method = RequestMethod.GET, produces = ConstantesUtil.APPLICATION_JSON)
    @CrossOrigin(origins = ConstantesUtil.CROSS_ORIGIN)
    public ListadoPacienteResponse obtenerListado() {
        try {
            return pacienteService.obtenerListado();
        } catch (Exception e) {
            log.debug(ConstantesUtil.LISTADO_PACIENTE);
            log.error(Arrays.toString(e.getStackTrace()));
            return new ListadoPacienteResponse(new RespuestaType(TipoMensaje.ERROR_INTERNO_SERVICIO));
        }
    }

    @RequestMapping(value = ConstantesUtil.OBTENER_PACIENTE, method = RequestMethod.GET, produces = ConstantesUtil.APPLICATION_JSON)
    @CrossOrigin(origins = ConstantesUtil.CROSS_ORIGIN)
    public PacienteResponse obtener(Long id) {
        try {
            return pacienteService.buscarPorId(id);
        } catch (Exception e) {
            log.debug(ConstantesUtil.OBTENER_PACIENTE);
            log.error(Arrays.toString(e.getStackTrace()));
            return new PacienteResponse(new RespuestaType(TipoMensaje.ERROR_INTERNO_SERVICIO));
        }
    }

    @RequestMapping(value = ConstantesUtil.GUARDAR_PACIENTE, method = RequestMethod.POST, produces = ConstantesUtil.APPLICATION_JSON)
    @CrossOrigin(origins = ConstantesUtil.CROSS_ORIGIN)
    public PacienteResponse guardar(@RequestBody PacienteRequest request) {
        try {
            return pacienteService.guardar(request);
        } catch (Exception e) {
            log.debug(ConstantesUtil.GUARDAR_PACIENTE);
            log.error(Arrays.toString(e.getStackTrace()));
            return new PacienteResponse(new RespuestaType(TipoMensaje.ERROR_INTERNO_SERVICIO));
        }
    }
}
