package com.mencarnacion.model.rest.request;

/**
 * Created by mencarnacion on 9/4/18.
 */
public class TipoMedicamentoRequest {

    private Long id;
    private String nombre;
    private String descripcion;
    private int estado;

    public TipoMedicamentoRequest() {
        super();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }
}
