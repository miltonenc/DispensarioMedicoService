package com.mencarnacion.model.entities;

import javax.persistence.*;
import java.util.List;

/**
 * Created by mencarnacion on 8/30/18.
 */
@Entity
@Table(name = "UBICACION", schema = "ISO715")
public class UbicacionEntity {

    private Long id;
    private String codigo;
    private String descripcion;
    private int estante;
    private int tramo;
    private int celda;
    private int estado;
    private List<MedicamentoEntity> medicamentos;

    public UbicacionEntity() {
        super();
        this.estado = 1;
    }

    @Id
    @Column(name = "ID")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Basic
    @Column(name = "CODIGO")
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    @Basic
    @Column(name = "DESCRIPCION")
    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Basic
    @Column(name = "ESTANTE")
    public int getEstante() {
        return estante;
    }

    public void setEstante(int estante) {
        this.estante = estante;
    }

    @Basic
    @Column(name = "TRAMO")
    public int getTramo() {
        return tramo;
    }

    public void setTramo(int tramo) {
        this.tramo = tramo;
    }

    @Basic
    @Column(name = "CELDA")
    public int getCelda() {
        return celda;
    }

    public void setCelda(int celda) {
        this.celda = celda;
    }

    @Basic
    @Column(name = "ESTADO")
    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    @OneToMany(mappedBy = "ubicacion")
    public List<MedicamentoEntity> getMedicamentos() {
        return medicamentos;
    }

    public void setMedicamentos(List<MedicamentoEntity> medicamentos) {
        this.medicamentos = medicamentos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UbicacionEntity that = (UbicacionEntity) o;

        if (id != that.id) return false;
        if (estante != that.estante) return false;
        if (tramo != that.tramo) return false;
        if (celda != that.celda) return false;
        if (estado != that.estado) return false;
        if (codigo != null ? !codigo.equals(that.codigo) : that.codigo != null) return false;
        if (descripcion != null ? !descripcion.equals(that.descripcion) : that.descripcion != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + (codigo != null ? codigo.hashCode() : 0);
        result = 31 * result + (descripcion != null ? descripcion.hashCode() : 0);
        result = 31 * result + estante;
        result = 31 * result + tramo;
        result = 31 * result + celda;
        result = 31 * result + estado;
        return result;
    }
}
