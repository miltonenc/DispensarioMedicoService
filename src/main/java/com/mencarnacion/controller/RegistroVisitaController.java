package com.mencarnacion.controller;

import com.mencarnacion.model.rest.request.RegistroVisitaRequest;
import com.mencarnacion.model.rest.response.ListadoRegistroVisitaResponse;
import com.mencarnacion.model.rest.response.RegistroVisitaResponse;
import com.mencarnacion.model.rest.response.RespuestaType;
import com.mencarnacion.service.RegistroVisitaService;
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
public class RegistroVisitaController {

    private static final Logger log = LoggerFactory.getLogger(RegistroVisitaController.class);

    @Autowired
    public RegistroVisitaService registroVisitaService;

    @RequestMapping(value = ConstantesUtil.LISTADO_REGISTRO_VISITA, method = RequestMethod.GET, produces = ConstantesUtil.APPLICATION_JSON)
    @CrossOrigin(origins = ConstantesUtil.CROSS_ORIGIN)
    public ListadoRegistroVisitaResponse obtenerListado() {
        try {
            return registroVisitaService.obtenerListado();
        } catch (Exception e) {
            log.debug(ConstantesUtil.LISTADO_REGISTRO_VISITA);
            log.error(Arrays.toString(e.getStackTrace()));
            return new ListadoRegistroVisitaResponse(new RespuestaType(TipoMensaje.ERROR_INTERNO_SERVICIO));
        }
    }

    @RequestMapping(value = ConstantesUtil.OBTENER_REGISTRO_VISITA, method = RequestMethod.GET, produces = ConstantesUtil.APPLICATION_JSON)
    @CrossOrigin(origins = ConstantesUtil.CROSS_ORIGIN)
    public RegistroVisitaResponse obtener(Long id) {
        try {
            return registroVisitaService.buscarPorId(id);
        } catch (Exception e) {
            log.debug(ConstantesUtil.OBTENER_REGISTRO_VISITA);
            log.error(Arrays.toString(e.getStackTrace()));
            return new RegistroVisitaResponse(new RespuestaType(TipoMensaje.ERROR_INTERNO_SERVICIO));
        }
    }

    @RequestMapping(value = ConstantesUtil.LISTADO_REGISTRO_PACIENTE, method = RequestMethod.GET, produces = ConstantesUtil.APPLICATION_JSON)
    @CrossOrigin(origins = ConstantesUtil.CROSS_ORIGIN)
    public ListadoRegistroVisitaResponse obtenerListadoPorPaciente(Long pacienteId) {
        try {
            return registroVisitaService.obtenerListadoPorPaciente(pacienteId);
        } catch (Exception e) {
            log.debug(ConstantesUtil.OBTENER_REGISTRO_VISITA);
            log.error(Arrays.toString(e.getStackTrace()));
            return new ListadoRegistroVisitaResponse(new RespuestaType(TipoMensaje.ERROR_INTERNO_SERVICIO));
        }
    }

    @RequestMapping(value = ConstantesUtil.LISTADO_REGISTRO_MEDICO, method = RequestMethod.GET, produces = ConstantesUtil.APPLICATION_JSON)
    @CrossOrigin(origins = ConstantesUtil.CROSS_ORIGIN)
    public ListadoRegistroVisitaResponse obtenerListadoPorMedico(Long medicoId) {
        try {
            return registroVisitaService.obtenerListadoPorMedico(medicoId);
        } catch (Exception e) {
            log.debug(ConstantesUtil.OBTENER_REGISTRO_VISITA);
            log.error(Arrays.toString(e.getStackTrace()));
            return new ListadoRegistroVisitaResponse(new RespuestaType(TipoMensaje.ERROR_INTERNO_SERVICIO));
        }
    }

    @RequestMapping(value = ConstantesUtil.GUARDAR_REGISTRO_VISITA, method = RequestMethod.POST, produces = ConstantesUtil.APPLICATION_JSON)
    @CrossOrigin(origins = ConstantesUtil.CROSS_ORIGIN)
    public RegistroVisitaResponse guardar(@RequestBody RegistroVisitaRequest request) {
        try {
            return registroVisitaService.guardar(request);
        } catch (Exception e) {
            log.debug(ConstantesUtil.GUARDAR_REGISTRO_VISITA);
            log.error(Arrays.toString(e.getStackTrace()));
            return new RegistroVisitaResponse(new RespuestaType(TipoMensaje.ERROR_INTERNO_SERVICIO));
        }
    }
}
