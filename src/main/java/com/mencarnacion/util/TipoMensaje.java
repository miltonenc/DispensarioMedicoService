package com.mencarnacion.util;

/**
 * Created by mencarnacion on 9/4/18.
 */
public enum TipoMensaje {
    OK("0", "OK"),
    TIPO_DATO_INCORRECTO("1000", "Parametro mandatorio es nulo, vacio o tipo de dato incorrecto."),
    ERROR_INTERNO_SERVICIO("5000", "Error interno del servicio."),
    NO_SE_ENCONTRARON_DATOS("2001", "No se encontraron datos."),
    ERROR_ACTUALIZANDO_DATOS("2003", "Error actualizando datos."),
    ERROR_INSERTANDO_DATOS("2002", "Error insertando datos."),
    ERROR_DATOS_DUPLICADOS("2004", "Dato duplicado.");

    private final String codigo;
    private final String descripcion;

    private TipoMensaje(String codigo, String descripcion) {
        this.codigo = codigo;
        this.descripcion = descripcion;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }
}
