package com.mencarnacion.model.dto;

import com.mencarnacion.model.entities.PacienteEntity;

/**
 * Created by mencarnacion on 10/16/18.
 */
public class PacienteDTO {

    private Long id;
    private Long personaId;
    private String nombre;
    private String apellido;
    private String dni;
    private String tipo;
    private String carnet;

    public PacienteDTO() {
        super();
    }

    public PacienteDTO(PacienteEntity pacienteEntity) {
        super();
        this.id = pacienteEntity.getId();
        this.personaId = pacienteEntity.getPersona().getId();
        this.nombre = pacienteEntity.getPersona().getNombre();
        this.apellido = pacienteEntity.getPersona().getApellido();
        this.dni = pacienteEntity.getPersona().getDni();
        this.tipo = pacienteEntity.getTipo().getNombre();
        this.carnet = pacienteEntity.getCarnet();
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPersonaId() {
        return personaId;
    }

    public void setPersonaId(Long personaId) {
        this.personaId = personaId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getCarnet() {
        return carnet;
    }

    public void setCarnet(String carnet) {
        this.carnet = carnet;
    }

    @Override
    public boolean equals(Object o) {

        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PacienteDTO that = (PacienteDTO) o;

        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (personaId != null ? !personaId.equals(that.personaId) : that.personaId != null) return false;
        if (nombre != null ? !nombre.equals(that.nombre) : that.nombre != null) return false;
        if (apellido != null ? !apellido.equals(that.apellido) : that.apellido != null) return false;
        if (dni != null ? !dni.equals(that.dni) : that.dni != null) return false;
        if (tipo != null ? !tipo.equals(that.tipo) : that.tipo != null) return false;
        return carnet != null ? carnet.equals(that.carnet) : that.carnet == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (personaId != null ? personaId.hashCode() : 0);
        result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
        result = 31 * result + (apellido != null ? apellido.hashCode() : 0);
        result = 31 * result + (dni != null ? dni.hashCode() : 0);
        result = 31 * result + (tipo != null ? tipo.hashCode() : 0);
        result = 31 * result + (carnet != null ? carnet.hashCode() : 0);
        return result;
    }
}
