package com.mencarnacion.controller;

import com.mencarnacion.model.rest.request.MedicamentoRequest;
import com.mencarnacion.model.rest.response.ListadoMedicamentoResponse;
import com.mencarnacion.model.rest.response.MedicamentoResponse;
import com.mencarnacion.model.rest.response.RespuestaType;
import com.mencarnacion.service.MedicamentoService;
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
public class MedicamentoController {

    private static final Logger log = LoggerFactory.getLogger(MedicamentoController.class);

    @Autowired
    public MedicamentoService medicamentoService;

    @RequestMapping(value = ConstantesUtil.LISTADO_MEDICAMENTO, method = RequestMethod.GET, produces = ConstantesUtil.APPLICATION_JSON)
    @CrossOrigin(origins = ConstantesUtil.CROSS_ORIGIN)
    public ListadoMedicamentoResponse obtenerListado() {
        try {
            return medicamentoService.obtenerListado();
        } catch (Exception e) {
            log.debug(ConstantesUtil.LISTADO_MEDICAMENTO);
            log.error(Arrays.toString(e.getStackTrace()));
            return new ListadoMedicamentoResponse(new RespuestaType(TipoMensaje.ERROR_INTERNO_SERVICIO));
        }
    }

    @RequestMapping(value = ConstantesUtil.OBTENER_MEDICAMENTO, method = RequestMethod.GET, produces = ConstantesUtil.APPLICATION_JSON)
    @CrossOrigin(origins = ConstantesUtil.CROSS_ORIGIN)
    public MedicamentoResponse obtener(Long id) {
        try {
            return medicamentoService.buscarPorId(id);
        } catch (Exception e) {
            log.debug(ConstantesUtil.OBTENER_MEDICAMENTO);
            log.error(Arrays.toString(e.getStackTrace()));
            return new MedicamentoResponse(new RespuestaType(TipoMensaje.ERROR_INTERNO_SERVICIO));
        }
    }

    @RequestMapping(value = ConstantesUtil.GUARDAR_MEDICAMENTO, method = RequestMethod.POST, produces = ConstantesUtil.APPLICATION_JSON)
    @CrossOrigin(origins = ConstantesUtil.CROSS_ORIGIN)
    public MedicamentoResponse guardar(MedicamentoRequest request) {
        try {
            return medicamentoService.guardar(request);
        } catch (Exception e) {
            log.debug(ConstantesUtil.GUARDAR_MEDICAMENTO);
            log.error(Arrays.toString(e.getStackTrace()));
            return new MedicamentoResponse(new RespuestaType(TipoMensaje.ERROR_INTERNO_SERVICIO));
        }
    }
}
