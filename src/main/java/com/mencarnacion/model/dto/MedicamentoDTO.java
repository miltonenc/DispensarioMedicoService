package com.mencarnacion.model.dto;

import com.mencarnacion.model.entities.MedicamentoEntity;

import java.math.BigDecimal;

/**
 * Created by mencarnacion on 10/16/18.
 */
public class MedicamentoDTO {

    private Long id;
    private String nombre;
    private String tipo;
    private String fabricante;
    private BigDecimal dosis;

    public MedicamentoDTO() {
        super();
    }

    public MedicamentoDTO(MedicamentoEntity medicamentoEntity) {
        super();
        this.id = medicamentoEntity.getId();
        this.nombre = medicamentoEntity.getNombre();
        this.tipo = medicamentoEntity.getTipo().getNombre();
        this.fabricante = medicamentoEntity.getFabricante().getNombre();
        this.dosis = medicamentoEntity.getDosis();
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

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

    public BigDecimal getDosis() {
        return dosis;
    }

    public void setDosis(BigDecimal dosis) {
        this.dosis = dosis;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MedicamentoDTO that = (MedicamentoDTO) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (nombre != null ? !nombre.equals(that.nombre) : that.nombre != null) return false;
        if (tipo != null ? !tipo.equals(that.tipo) : that.tipo != null) return false;
        if (fabricante != null ? !fabricante.equals(that.fabricante) : that.fabricante != null) return false;
        return dosis != null ? dosis.equals(that.dosis) : that.dosis == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
        result = 31 * result + (tipo != null ? tipo.hashCode() : 0);
        result = 31 * result + (fabricante != null ? fabricante.hashCode() : 0);
        result = 31 * result + (dosis != null ? dosis.hashCode() : 0);
        return result;
    }
}
