package com.mencarnacion.service;

import com.mencarnacion.model.rest.response.ListadoUsuarioResponse;
import com.mencarnacion.model.rest.response.UsuarioResponse;


/**
 * Created by mencarnacion on 10/07/18.
 */
public interface UsuarioService {

    UsuarioResponse buscarPorId(Long id);

    UsuarioResponse login(String pUsuario, String pPassword);

    ListadoUsuarioResponse obtenerListado();

    ListadoUsuarioResponse obtenerListadoByUsuario(String pUsuario);

    boolean isExisteUsuario(String pUsuario);
}
