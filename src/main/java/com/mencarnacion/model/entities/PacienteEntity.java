package com.mencarnacion.model.entities;

import javax.persistence.*;
import java.util.List;

/**
 * Created by mencarnacion on 8/30/18.
 */
@Entity
@Table(name = "PACIENTE", schema = "ISO715")
public class PacienteEntity {

    private Long id;
    private PersonaEntity persona;
    private TipoPacienteEntity tipo;
    private String carnet;
    private UsuarioEntity usuario;
    private int estado;
    List<RegistroVisitaEntity> registrosVisitas;

    public PacienteEntity() {
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

    @JoinColumn(name = "PERSONA", referencedColumnName = "ID")
    @ManyToOne()
    public PersonaEntity getPersona() {
        return persona;
    }

    public void setPersona(PersonaEntity persona) {
        this.persona = persona;
    }

    @JoinColumn(name = "TIPO", referencedColumnName = "ID")
    @ManyToOne
    public TipoPacienteEntity getTipo() {
        return tipo;
    }

    public void setTipo(TipoPacienteEntity tipo) {
        this.tipo = tipo;
    }

    @Basic
    @Column(name = "CARNET")
    public String getCarnet() {
        return carnet;
    }

    public void setCarnet(String carnet) {
        this.carnet = carnet;
    }

    @JoinColumn(name = "USUARIO_ID", referencedColumnName = "ID")
    @ManyToOne()
    public UsuarioEntity getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioEntity usuario) {
        this.usuario = usuario;
    }

    @Basic
    @Column(name = "ESTADO")
    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    @OneToMany(mappedBy = "paciente")
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

        PacienteEntity that = (PacienteEntity) o;

        if (id != that.id) return false;
        if (persona != that.persona) return false;
        if (tipo != that.tipo) return false;
        if (estado != that.estado) return false;
        if (carnet != null ? !carnet.equals(that.carnet) : that.carnet != null) return false;
        if (usuario != null ? !usuario.equals(that.usuario) : that.usuario != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id.hashCode();
        result = 31 * result + (persona != null ? persona.hashCode() : 0);
        result = 31 * result + (tipo != null ? tipo.hashCode() : 0);
        result = 31 * result + (carnet != null ? carnet.hashCode() : 0);
        result = 31 * result + (usuario != null ? usuario.hashCode() : 0);
        result = 31 * result + estado;
        return result;
    }
}
