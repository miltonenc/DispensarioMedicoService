package com.mencarnacion.controller;

import com.mencarnacion.model.rest.request.UbicacionRequest;
import com.mencarnacion.model.rest.response.ListadoUbicacionResponse;
import com.mencarnacion.model.rest.response.RespuestaType;
import com.mencarnacion.model.rest.response.UbicacionResponse;
import com.mencarnacion.service.UbicacionService;
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
public class UbicacionController {

    private static final Logger log = LoggerFactory.getLogger(UbicacionController.class);

    @Autowired
    public UbicacionService ubicacionService;

    @RequestMapping(value = ConstantesUtil.LISTADO_UBICACION, method = RequestMethod.GET, produces = ConstantesUtil.APPLICATION_JSON)
    @CrossOrigin(origins = ConstantesUtil.CROSS_ORIGIN)
    public ListadoUbicacionResponse obtenerListado() {
        try {
            return ubicacionService.obtenerListado();
        } catch (Exception e) {
            log.debug(ConstantesUtil.LISTADO_UBICACION);
            log.error(Arrays.toString(e.getStackTrace()));
            return new ListadoUbicacionResponse(new RespuestaType(TipoMensaje.ERROR_INTERNO_SERVICIO));
        }
    }

    @RequestMapping(value = ConstantesUtil.OBTENER_UBICACION, method = RequestMethod.GET, produces = ConstantesUtil.APPLICATION_JSON)
    @CrossOrigin(origins = ConstantesUtil.CROSS_ORIGIN)
    public UbicacionResponse obtener(Long id) {
        try {
            return ubicacionService.buscarPorId(id);
        } catch (Exception e) {
            log.debug(ConstantesUtil.OBTENER_UBICACION);
            log.error(Arrays.toString(e.getStackTrace()));
            return new UbicacionResponse(new RespuestaType(TipoMensaje.ERROR_INTERNO_SERVICIO));
        }
    }

    @RequestMapping(value = ConstantesUtil.OBTENER_UBICACION_CODIGO, method = RequestMethod.POST, produces = ConstantesUtil.APPLICATION_JSON)
    @CrossOrigin(origins = ConstantesUtil.CROSS_ORIGIN)
    public UbicacionResponse obtenerPorCodigo(String pCodigo) {
        try {
            return ubicacionService.buscarPorCodigo(pCodigo);
        } catch (Exception e) {
            log.debug(ConstantesUtil.OBTENER_UBICACION_CODIGO);
            log.error(Arrays.toString(e.getStackTrace()));
            return new UbicacionResponse(new RespuestaType(TipoMensaje.ERROR_INTERNO_SERVICIO));
        }
    }

    @RequestMapping(value = ConstantesUtil.GUARDAR_UBICACION, method = RequestMethod.POST, produces = ConstantesUtil.APPLICATION_JSON)
    @CrossOrigin(origins = ConstantesUtil.CROSS_ORIGIN)
    public UbicacionResponse guardar(@RequestBody UbicacionRequest request) {
        try {
            return ubicacionService.guardar(request);
        } catch (Exception e) {
            log.debug(ConstantesUtil.GUARDAR_UBICACION);
            log.error(Arrays.toString(e.getStackTrace()));
            return new UbicacionResponse(new RespuestaType(TipoMensaje.ERROR_INTERNO_SERVICIO));
        }
    }
}
