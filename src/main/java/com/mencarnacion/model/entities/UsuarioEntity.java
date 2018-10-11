package com.mencarnacion.model.entities;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "USUARIO", schema = "ISO715")
public class UsuarioEntity {
    private Long id;
    private String usuario;
    private String password;
    private int estado;
    private List<UsuarioRolEntity> roles;
    private List<PacienteEntity> pacientes;
    private List<MedicoEntity> medicos;

    public UsuarioEntity() {
        super();
        this.estado = 1;
    }

    public UsuarioEntity(String usuario, String password) {
        super();
        this.usuario = usuario;
        this.password = password;
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
    @Column(name = "USUARIO")
    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    @Basic
    @Column(name = "PASSWORD")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "ESTADO")
    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    @OneToMany(mappedBy = "usuario")
    public List<UsuarioRolEntity> getRoles() {
        return roles;
    }

    public void setRoles(List<UsuarioRolEntity> roles) {
        this.roles = roles;
    }

    @OneToMany(mappedBy = "usuario")
    public List<PacienteEntity> getPacientes() {
        return pacientes;
    }

    public void setPacientes(List<PacienteEntity> pacientes) {
        this.pacientes = pacientes;
    }


    @OneToMany(mappedBy = "usuario")
    public List<MedicoEntity> getMedicos() {
        return medicos;
    }

    public void setMedicos(List<MedicoEntity> medicos) {
        this.medicos = medicos;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UsuarioEntity that = (UsuarioEntity) o;
        return estado == that.estado &&
                Objects.equals(id, that.id) &&
                Objects.equals(usuario, that.usuario) &&
                Objects.equals(password, that.password) &&
                Objects.equals(roles, that.roles) &&
                Objects.equals(pacientes, that.pacientes) &&
                Objects.equals(medicos, that.medicos);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, usuario, password, estado, roles, pacientes, medicos);
    }
}
