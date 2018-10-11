package com.mencarnacion.model.entities;

import javax.persistence.*;
import java.util.List;

/**
 * Created by mencarnacion on 8/30/18.
 */
@Entity
@Table(name = "LABORATORIO_FABRICANTE", schema = "ISO715")
public class LaboratorioFabricanteEntity {


    private Long id;
    private String nombre;
    private String descripcion;
    private int estado;

    @Transient
    private List<MedicamentoEntity> medicamentos;

    public LaboratorioFabricanteEntity() {
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
    @Column(name = "NOMBRE")
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
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
    @Column(name = "ESTADO")
    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    @OneToMany(mappedBy = "fabricante")
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

        LaboratorioFabricanteEntity that = (LaboratorioFabricanteEntity) o;

        if (estado != that.estado) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (!nombre.equals(that.nombre)) return false;
        return descripcion != null ? descripcion.equals(that.descripcion) : that.descripcion == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + nombre.hashCode();
        result = 31 * result + (descripcion != null ? descripcion.hashCode() : 0);
        result = 31 * result + estado;
        return result;
    }
}
