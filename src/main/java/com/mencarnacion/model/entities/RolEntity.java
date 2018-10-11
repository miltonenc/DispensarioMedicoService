package com.mencarnacion.model.entities;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "ROL", schema = "ISO715")
public class RolEntity {
    private Long id;
    private String codigo;
    private String descripcion;
    private List<UsuarioRolEntity> roles;

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
    @Column(name = "CODIGO")
    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    @Basic
    @Column(name = "DESCRIPCION")
    public String getDescripcion() {
        return descripcion;
    }

    @OneToMany(mappedBy = "rol")
    public List<UsuarioRolEntity> getRoles() {
        return roles;
    }

    public void setRoles(List<UsuarioRolEntity> roles) {
        this.roles = roles;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RolEntity rolEntity = (RolEntity) o;
        return id == rolEntity.id &&
                Objects.equals(codigo, rolEntity.codigo) &&
                Objects.equals(descripcion, rolEntity.descripcion);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, codigo, descripcion);
    }
}
