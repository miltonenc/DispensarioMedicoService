package com.mencarnacion.util;

/**
 * Created by mencarnacion on 10/7/18.
 */
public enum Rol {
    ESTUDIANTE(1L, "Estudiante"),
    PROFESOR(2L, "Profesor"),
    MEDICO(3L, "Medico"),
    EMPLEADO(4L, "Empleado"),
    ADMINISTRADOR(5L, "Administrador");

    private final Long id;
    private final String descripcion;

    private Rol(Long id, String descripcion) {
        this.id = id;
        this.descripcion = descripcion;
    }

    public Long getId() {
        return id;
    }

    public String getDescripcion() {
        return descripcion;
    }
}
