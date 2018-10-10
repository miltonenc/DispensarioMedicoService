package com.mencarnacion.controller;

import com.mencarnacion.model.rest.request.MedicoEspecialidadRequest;
import com.mencarnacion.model.rest.response.ListadoMedicoEspecialidadResponse;
import com.mencarnacion.model.rest.response.MedicoEspecialidadResponse;
import com.mencarnacion.model.rest.response.RespuestaType;
import com.mencarnacion.service.MedicoEspecialidadService;
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
public class MedicoEspecialidadController {

    private static final Logger log = LoggerFactory.getLogger(MedicoEspecialidadController.class);

    @Autowired
    public MedicoEspecialidadService medicoEspecialidadService;

    @RequestMapping(value = ConstantesUtil.LISTADO_MEDICO_ESPECIALIDAD, method = RequestMethod.GET, produces = ConstantesUtil.APPLICATION_JSON)
    @CrossOrigin(origins = ConstantesUtil.CROSS_ORIGIN)
    public ListadoMedicoEspecialidadResponse obtenerListado() {
        try {
            return medicoEspecialidadService.obtenerListado();
        } catch (Exception e) {
            log.debug(ConstantesUtil.LISTADO_MEDICO_ESPECIALIDAD);
            log.error(Arrays.toString(e.getStackTrace()));
            return new ListadoMedicoEspecialidadResponse(new RespuestaType(TipoMensaje.ERROR_INTERNO_SERVICIO));
        }
    }

    @RequestMapping(value = ConstantesUtil.OBTENER_MEDICO_ESPECIALIDAD, method = RequestMethod.GET, produces = ConstantesUtil.APPLICATION_JSON)
    @CrossOrigin(origins = ConstantesUtil.CROSS_ORIGIN)
    public MedicoEspecialidadResponse obtener(Long id) {
        try {
            return medicoEspecialidadService.buscarPorId(id);
        } catch (Exception e) {
            log.debug(ConstantesUtil.OBTENER_MEDICO_ESPECIALIDAD);
            log.error(Arrays.toString(e.getStackTrace()));
            return new MedicoEspecialidadResponse(new RespuestaType(TipoMensaje.ERROR_INTERNO_SERVICIO));
        }
    }

    @RequestMapping(value = ConstantesUtil.GUARDAR_MEDICO_ESPECIALIDAD, method = RequestMethod.POST, produces = ConstantesUtil.APPLICATION_JSON)
    @CrossOrigin(origins = ConstantesUtil.CROSS_ORIGIN)
    public MedicoEspecialidadResponse guardar(MedicoEspecialidadRequest request) {
        try {
            return medicoEspecialidadService.guardar(request);
        } catch (Exception e) {
            log.debug(ConstantesUtil.GUARDAR_MEDICO_ESPECIALIDAD);
            log.error(Arrays.toString(e.getStackTrace()));
            return new MedicoEspecialidadResponse(new RespuestaType(TipoMensaje.ERROR_INTERNO_SERVICIO));
        }
    }
}
