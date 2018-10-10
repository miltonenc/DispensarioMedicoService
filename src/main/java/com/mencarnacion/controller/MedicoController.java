package com.mencarnacion.controller;

import com.mencarnacion.model.rest.request.MedicoRequest;
import com.mencarnacion.model.rest.response.ListadoMedicoResponse;
import com.mencarnacion.model.rest.response.MedicoResponse;
import com.mencarnacion.model.rest.response.RespuestaType;
import com.mencarnacion.service.MedicoService;
import com.mencarnacion.util.ConstantesUtil;
import com.mencarnacion.util.TipoMensaje;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

/**
 * Created by mencarnacion on 8/28/18.
 */
@RestController
@RequestMapping(ConstantesUtil.API)
public class MedicoController {

    private static final Logger log = LoggerFactory.getLogger(MedicoController.class);

    @Autowired
    public MedicoService medicoService;

    @RequestMapping(value = ConstantesUtil.LISTADO_MEDICO, method = RequestMethod.GET, produces = ConstantesUtil.APPLICATION_JSON)
    @CrossOrigin(origins = ConstantesUtil.CROSS_ORIGIN)
    public ListadoMedicoResponse obtenerListado() {
        try {
            return medicoService.obtenerListado();
        } catch (Exception e) {
            log.debug(ConstantesUtil.LISTADO_MEDICO);
            log.error(Arrays.toString(e.getStackTrace()));
            return new ListadoMedicoResponse(new RespuestaType(TipoMensaje.ERROR_INTERNO_SERVICIO));
        }
    }

    @RequestMapping(value = ConstantesUtil.OBTENER_MEDICO, method = RequestMethod.GET, produces = ConstantesUtil.APPLICATION_JSON)
    @CrossOrigin(origins = ConstantesUtil.CROSS_ORIGIN)
    public MedicoResponse obtener(Long id) {
        try {
            return medicoService.buscarPorId(id);
        } catch (Exception e) {
            log.debug(ConstantesUtil.OBTENER_MEDICO);
            log.error(Arrays.toString(e.getStackTrace()));
            return new MedicoResponse(new RespuestaType(TipoMensaje.ERROR_INTERNO_SERVICIO));
        }
    }

    @RequestMapping(value = ConstantesUtil.GUARDAR_MEDICO, method = RequestMethod.POST, produces = ConstantesUtil.APPLICATION_JSON)
    @CrossOrigin(origins = ConstantesUtil.CROSS_ORIGIN)
    public MedicoResponse guardar(MedicoRequest request) {
        try {
            return medicoService.guardar(request);
        } catch (Exception e) {
            log.debug(ConstantesUtil.GUARDAR_MEDICO);
            log.error(Arrays.toString(e.getStackTrace()));
            return new MedicoResponse(new RespuestaType(TipoMensaje.ERROR_INTERNO_SERVICIO));
        }
    }
}
