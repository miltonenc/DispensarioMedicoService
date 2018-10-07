package com.mencarnacion.model.rest.response;

import com.mencarnacion.util.TipoMensaje;

import java.io.Serializable;

/**
 * Created by mencarnacion on 9/4/18.
 */
public class RespuestaType implements Serializable {
    private String codigo;
    private String descripcion;

    public RespuestaType(TipoMensaje mensaje) {
        super();
        this.codigo = mensaje.getCodigo();
        this.descripcion = mensaje.getDescripcion();
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
}
