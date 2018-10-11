package com.mencarnacion.controller;

import com.mencarnacion.model.rest.request.TipoMedicamentoRequest;
import com.mencarnacion.model.rest.response.ListadoTipoMedicamentoResponse;
import com.mencarnacion.model.rest.response.RespuestaType;
import com.mencarnacion.model.rest.response.TipoMedicamentoResponse;
import com.mencarnacion.service.TipoMedicamentoService;
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
public class TipoMedicamentoController {

    private static final Logger log = LoggerFactory.getLogger(TipoMedicamentoController.class);

    @Autowired
    public TipoMedicamentoService tipoMedicamentoService;

    @RequestMapping(value = ConstantesUtil.LISTADO_TIPO_MEDICAMENTOS, method = RequestMethod.GET, produces = ConstantesUtil.APPLICATION_JSON)
    @CrossOrigin(origins = ConstantesUtil.CROSS_ORIGIN)
    public ListadoTipoMedicamentoResponse obtenerListado() {
        try {
            return tipoMedicamentoService.obtenerListado();
        } catch (Exception e) {
            log.debug(ConstantesUtil.LISTADO_TIPO_MEDICAMENTOS);
            log.error(Arrays.toString(e.getStackTrace()));
            return new ListadoTipoMedicamentoResponse(new RespuestaType(TipoMensaje.ERROR_INTERNO_SERVICIO));
        }
    }

    @RequestMapping(value = ConstantesUtil.OBTENER_TIPO_MEDICAMENTOS, method = RequestMethod.GET, produces = ConstantesUtil.APPLICATION_JSON)
    @CrossOrigin(origins = ConstantesUtil.CROSS_ORIGIN)
    public TipoMedicamentoResponse obtener(Long id) {
        try {
            return tipoMedicamentoService.buscarPorId(id);
        } catch (Exception e) {
            log.debug(ConstantesUtil.OBTENER_TIPO_MEDICAMENTOS);
            log.error(Arrays.toString(e.getStackTrace()));
            return new TipoMedicamentoResponse(new RespuestaType(TipoMensaje.ERROR_INTERNO_SERVICIO));
        }
    }

    @RequestMapping(value = ConstantesUtil.GUARDAR_TIPO_MEDICAMENTOS, method = RequestMethod.POST, produces = ConstantesUtil.APPLICATION_JSON)
    @CrossOrigin(origins = ConstantesUtil.CROSS_ORIGIN)
    public TipoMedicamentoResponse guardar(@RequestBody TipoMedicamentoRequest request) {
        try {
            return tipoMedicamentoService.guardar(request);
        } catch (Exception e) {
            log.debug(ConstantesUtil.GUARDAR_TIPO_MEDICAMENTOS);
            log.error(Arrays.toString(e.getStackTrace()));
            return new TipoMedicamentoResponse(new RespuestaType(TipoMensaje.ERROR_INTERNO_SERVICIO));
        }
    }
}
