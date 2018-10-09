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
    private int estado;
    private List<UsuarioRolDTO> roles;

    public UsuarioDTO(String usuario, String password) {
        super();
        this.usuario = usuario;
        this.password = password;
        this.estado = 1;
    }

    public UsuarioDTO(Long id, String usuario, String password, List<UsuarioRolEntity> roles) {
        super();
        this.id = id;
        this.usuario = usuario;
        this.password = password;
        this.estado = 1;
        this.roles = convertRolEtityToDTO(roles);
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UsuarioDTO that = (UsuarioDTO) o;
        return estado == that.estado &&
                Objects.equals(id, that.id) &&
                Objects.equals(usuario, that.usuario) &&
                Objects.equals(password, that.password) &&
                Objects.equals(roles, that.roles);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, usuario, password, estado, roles);
    }
}
