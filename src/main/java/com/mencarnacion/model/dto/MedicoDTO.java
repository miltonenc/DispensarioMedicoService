package com.mencarnacion.model.dto;

import com.mencarnacion.model.entities.MedicoEntity;

/**
 * Created by mencarnacion on 10/16/18.
 */
public class MedicoDTO {

    private Long id;
    private Long personaId;
    private String nombre;
    private String apellido;
    private String dni;
    private Long especialidadId;
    private String especialidad;
    private String tandaLabor;

    public MedicoDTO() {
        super();
    }

    public MedicoDTO(MedicoEntity medicoEntity) {
        this.id = medicoEntity.getId();
        this.personaId = medicoEntity.getPersona().getId();
        this.nombre = medicoEntity.getPersona().getNombre();
        this.apellido = medicoEntity.getPersona().getApellido();
        this.dni = medicoEntity.getPersona().getDni();
        this.especialidadId = medicoEntity.getEspecialidad().getId();
        this.especialidad = medicoEntity.getEspecialidad().getNombre();
        this.tandaLabor = medicoEntity.getTandaLabor();
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

    public Long getEspecialidadId() {
        return especialidadId;
    }

    public void setEspecialidadId(Long especialidadId) {
        this.especialidadId = especialidadId;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public String getTandaLabor() {
        return tandaLabor;
    }

    public void setTandaLabor(String tandaLabor) {
        this.tandaLabor = tandaLabor;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MedicoDTO medicoDTO = (MedicoDTO) o;

        if (id != null ? !id.equals(medicoDTO.id) : medicoDTO.id != null) return false;
        if (personaId != null ? !personaId.equals(medicoDTO.personaId) : medicoDTO.personaId != null) return false;
        if (nombre != null ? !nombre.equals(medicoDTO.nombre) : medicoDTO.nombre != null) return false;
        if (apellido != null ? !apellido.equals(medicoDTO.apellido) : medicoDTO.apellido != null) return false;
        if (dni != null ? !dni.equals(medicoDTO.dni) : medicoDTO.dni != null) return false;
        if (especialidadId != null ? !especialidadId.equals(medicoDTO.especialidadId) : medicoDTO.especialidadId != null)
            return false;
        if (especialidad != null ? !especialidad.equals(medicoDTO.especialidad) : medicoDTO.especialidad != null)
            return false;
        if (tandaLabor != null ? !tandaLabor.equals(medicoDTO.tandaLabor) : medicoDTO.tandaLabor != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (personaId != null ? personaId.hashCode() : 0);
        result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
        result = 31 * result + (apellido != null ? apellido.hashCode() : 0);
        result = 31 * result + (dni != null ? dni.hashCode() : 0);
        result = 31 * result + (especialidadId != null ? especialidadId.hashCode() : 0);
        result = 31 * result + (especialidad != null ? especialidad.hashCode() : 0);
        result = 31 * result + (tandaLabor != null ? tandaLabor.hashCode() : 0);
        return result;
    }
}
