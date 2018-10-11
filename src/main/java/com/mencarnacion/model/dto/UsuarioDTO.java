package com.mencarnacion.model.dto;

import com.mencarnacion.model.entities.MedicoEntity;
import com.mencarnacion.model.entities.PacienteEntity;
import com.mencarnacion.model.entities.UsuarioRolEntity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;


public class UsuarioDTO {
    private Long id;
    private String usuario;
    private String password;
    private Long personaId;
    private String nombre;
    private String apellido;
    private String dni;
    private int estado;
    private List<UsuarioRolDTO> roles;

    public UsuarioDTO(Long id, String usuario, String password, List<UsuarioRolEntity> roles, List<MedicoEntity> medicos, List<PacienteEntity> pacientes) {
        super();
        this.id = id;
        this.usuario = usuario;
        this.password = password;
        this.estado = 1;
        this.roles = convertRolEtityToDTO(roles);
        if(Objects.nonNull(medicos) && !medicos.isEmpty()){
            MedicoEntity medicoTmp = medicos.get(0);
            this.personaId = medicoTmp.getPersona().getId();
            this.nombre = medicoTmp.getPersona().getNombre();
            this.apellido = medicoTmp.getPersona().getApellido();
            this.dni = medicoTmp.getPersona().getDni();
        }else if(Objects.nonNull(pacientes) && !pacientes.isEmpty()){
            PacienteEntity pacienteTmp = pacientes.get(0);
            this.personaId = pacienteTmp.getPersona().getId();
            this.nombre = pacienteTmp.getPersona().getNombre();
            this.apellido = pacienteTmp.getPersona().getApellido();
            this.dni = pacienteTmp.getPersona().getDni();
        }

    }

    private List<UsuarioRolDTO> convertRolEtityToDTO(List<UsuarioRolEntity> rolesEntity){
        List<UsuarioRolDTO> usuarioRolDTOS = new ArrayList<>();

        for (UsuarioRolEntity rolEntity : rolesEntity){
            usuarioRolDTOS.add(new UsuarioRolDTO(rolEntity.getId(), rolEntity.getRol().getCodigo(), rolEntity.getRol().getDescripcion()));
        }

        return usuarioRolDTOS;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public List<UsuarioRolDTO> getRoles() {
        return roles;
    }

    public void setRoles(List<UsuarioRolDTO> roles) {
        this.roles = roles;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        UsuarioDTO that = (UsuarioDTO) o;

        if (estado != that.estado) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        if (usuario != null ? !usuario.equals(that.usuario) : that.usuario != null) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;
        if (personaId != null ? !personaId.equals(that.personaId) : that.personaId != null) return false;
        if (nombre != null ? !nombre.equals(that.nombre) : that.nombre != null) return false;
        if (apellido != null ? !apellido.equals(that.apellido) : that.apellido != null) return false;
        if (dni != null ? !dni.equals(that.dni) : that.dni != null) return false;
        return roles != null ? roles.equals(that.roles) : that.roles == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (usuario != null ? usuario.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (personaId != null ? personaId.hashCode() : 0);
        result = 31 * result + (nombre != null ? nombre.hashCode() : 0);
        result = 31 * result + (apellido != null ? apellido.hashCode() : 0);
        result = 31 * result + (dni != null ? dni.hashCode() : 0);
        result = 31 * result + estado;
        result = 31 * result + (roles != null ? roles.hashCode() : 0);
        return result;
    }
}
