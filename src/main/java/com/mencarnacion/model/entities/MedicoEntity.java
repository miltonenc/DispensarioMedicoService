package com.mencarnacion.model.entities;

import javax.persistence.*;
import java.util.List;

/**
 * Created by mencarnacion on 8/30/18.
 */
@Entity
@Table(name = "MEDICO", schema = "ISO715")
public class MedicoEntity {
    private Long id;
    private PersonaEntity persona;
    private MedicoEspecialidadEntity especialidad;
    private String tandaLabor;
    private int estado;
    List<RegistroVisitaEntity> registrosVisitas;

    public MedicoEntity() {
        super();
        this.estado = 1;
    }

    @Id
    @Column(name = "ID")
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @JoinColumn(name = "PERSONA", referencedColumnName = "ID")
    @ManyToOne
    public PersonaEntity getPersona() {
        return persona;
    }

    public void setPersona(PersonaEntity persona) {
        this.persona = persona;
    }

    @JoinColumn(name = "ESPECIALIDAD", referencedColumnName = "ID")
    @ManyToOne
    public MedicoEspecialidadEntity getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(MedicoEspecialidadEntity especialidad) {
        this.especialidad = especialidad;
    }

    @Basic
    @Column(name = "TANDA_LABOR")
    public String getTandaLabor() {
        return tandaLabor;
    }

    public void setTandaLabor(String tandaLabor) {
        this.tandaLabor = tandaLabor;
    }

    @Basic
    @Column(name = "ESTADO")
    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    @OneToMany(mappedBy = "medico")
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

        MedicoEntity that = (MedicoEntity) o;

        if (id != that.id) return false;
        if (persona != that.persona) return false;
        if (especialidad != that.especialidad) return false;
        if (estado != that.estado) return false;
        if (tandaLabor != null ? !tandaLabor.equals(that.tandaLabor) : that.tandaLabor != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + (persona != null ? persona.hashCode() : 0);
        result = 31 * result + (especialidad != null ? especialidad.hashCode() : 0);
        result = 31 * result + (tandaLabor != null ? tandaLabor.hashCode() : 0);
        result = 31 * result + estado;
        return result;
    }
}
