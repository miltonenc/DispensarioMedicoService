package com.mencarnacion.model.entities;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

/**
 * Created by mencarnacion on 8/30/18.
 */
@Entity
@Table(name = "MEDICAMENTO", schema = "ISO715")
public class MedicamentoEntity {
    private Long id;
    private String nombre;
    private String descripcion;
    private TipoMedicamentoEntity tipo;
    private LaboratorioFabricanteEntity fabricante;
    private UbicacionEntity ubicacion;
    private BigDecimal dosis;
    private int estado;
    List<RegistroVisitaEntity> registrosVisitas;

    public MedicamentoEntity() {
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

    @JoinColumn(name = "TIPO", referencedColumnName = "ID")
    @ManyToOne
    public TipoMedicamentoEntity getTipo() {
        return tipo;
    }

    public void setTipo(TipoMedicamentoEntity tipo) {
        this.tipo = tipo;
    }

    @JoinColumn(name = "FABRICANTE", referencedColumnName = "ID")
    @ManyToOne
    public LaboratorioFabricanteEntity getFabricante() {
        return fabricante;
    }

    public void setFabricante(LaboratorioFabricanteEntity fabricante) {
        this.fabricante = fabricante;
    }

    @JoinColumn(name = "UBICACION", referencedColumnName = "ID")
    @ManyToOne
    public UbicacionEntity getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(UbicacionEntity ubicacion) {
        this.ubicacion = ubicacion;
    }

    @Basic
    @Column(name = "DOSIS")
    public BigDecimal getDosis() {
        return dosis;
    }

    public void setDosis(BigDecimal dosis) {
        this.dosis = dosis;
    }

    @Basic
    @Column(name = "ESTADO")
    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    @OneToMany(mappedBy = "medicamento")
    public List<RegistroVisitaEntity> getRegistrosVisitas() {
        return registrosVisitas;
    }

    public void setRegistrosVisitas(List<RegistroVisitaEntity> registrosVisitas) {
        this.registrosVisitas = registrosVisitas;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MedicamentoEntity that = (MedicamentoEntity) o;

        if (id != that.id) return false;
        if (tipo != that.tipo) return false;
        if (fabricante != that.fabricante) return false;
        if (ubicacion != that.ubicacion) return false;
        if (estado != that.estado) return false;
        if (nombre != null ? !nombre.equals(that.nombre) : that.nombre != null) return false;
        if (descripcion != null ? !descripcion.equals(that.descripcion) : that.descripcion != null) return false;
        if (dosis != null ? !dosis.equals(that.dosis) : that.dosis != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
        result = 31 * result + (descripcion != null ? descripcion.hashCode() : 0);
        result = 31 * result + (tipo != null ? tipo.hashCode() : 0);
        result = 31 * result + (fabricante != null ? fabricante.hashCode() : 0);
        result = 31 * result + (ubicacion != null ? ubicacion.hashCode() : 0);
        result = 31 * result + (dosis != null ? dosis.hashCode() : 0);
        result = 31 * result + estado;
        return result;
    }
}
