package com.mencarnacion.controller;

import com.mencarnacion.model.rest.response.ListadoUsuarioResponse;
import com.mencarnacion.model.rest.response.RespuestaType;
import com.mencarnacion.model.rest.response.UsuarioResponse;
import com.mencarnacion.service.UsuarioService;
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
 * Created by mencarnacion on 10/07/18.
 */
@RestController
@RequestMapping(ConstantesUtil.API)
public class UsuarioController {

    private static final Logger log = LoggerFactory.getLogger(UsuarioController.class);

    @Autowired
    public UsuarioService usuarioService;

    @RequestMapping(value = ConstantesUtil.LISTADO_USUARIO, method = RequestMethod.GET, produces = ConstantesUtil.APPLICATION_JSON)
    @CrossOrigin(origins = ConstantesUtil.CROSS_ORIGIN)
    public ListadoUsuarioResponse obtenerListado() {
        try {
            return usuarioService.obtenerListado();
        } catch (Exception e) {
            log.debug(ConstantesUtil.LISTADO_USUARIO);
            log.error(Arrays.toString(e.getStackTrace()));
            return new ListadoUsuarioResponse(new RespuestaType(TipoMensaje.ERROR_INTERNO_SERVICIO));
        }
    }

    @RequestMapping(value = ConstantesUtil.LISTADO_USUARIO_USUARIO, method = RequestMethod.GET, produces = ConstantesUtil.APPLICATION_JSON)
    @CrossOrigin(origins = ConstantesUtil.CROSS_ORIGIN)
    public ListadoUsuarioResponse obtenerListadoByUsuario(String pUsuario) {
        try {
            return usuarioService.obtenerListadoByUsuario(pUsuario);
        } catch (Exception e) {
            log.debug(ConstantesUtil.LISTADO_USUARIO_USUARIO);
            log.error(Arrays.toString(e.getStackTrace()));
            return new ListadoUsuarioResponse(new RespuestaType(TipoMensaje.ERROR_INTERNO_SERVICIO));
        }
    }

    @RequestMapping(value = ConstantesUtil.OBTENER_USUARIO, method = RequestMethod.GET, produces = ConstantesUtil.APPLICATION_JSON)
    @CrossOrigin(origins = ConstantesUtil.CROSS_ORIGIN)
    public UsuarioResponse obtener(Long id) {
        try {
            return usuarioService.buscarPorId(id);
        } catch (Exception e) {
            log.debug(ConstantesUtil.OBTENER_USUARIO);
            log.error(Arrays.toString(e.getStackTrace()));
            return new UsuarioResponse(new RespuestaType(TipoMensaje.ERROR_INTERNO_SERVICIO));
        }
    }

    @RequestMapping(value = ConstantesUtil.LOGIN, method = RequestMethod.GET, produces = ConstantesUtil.APPLICATION_JSON)
    @CrossOrigin(origins = ConstantesUtil.CROSS_ORIGIN)
    public UsuarioResponse login(String pUsuario, String pPassword) {
        try {
            return usuarioService.login(pUsuario, pPassword);
        } catch (Exception e) {
            log.debug(ConstantesUtil.LOGIN);
            log.error(Arrays.toString(e.getStackTrace()));
            return new UsuarioResponse(new RespuestaType(TipoMensaje.ERROR_INTERNO_SERVICIO));
        }
    }

    @RequestMapping(value = ConstantesUtil.VALIDAR_USUARIO, method = RequestMethod.GET, produces = ConstantesUtil.APPLICATION_JSON)
    @CrossOrigin(origins = ConstantesUtil.CROSS_ORIGIN)
    public boolean isExisteUsuario(String pUsuario) {
        return usuarioService.isExisteUsuario(pUsuario);
    }
}
