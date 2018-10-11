package com.mencarnacion.model.entities;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "USUARIO_ROL", schema = "ISO715")
public class UsuarioRolEntity {
    private Long id;
    private UsuarioEntity usuario;
    private RolEntity rol;
    private int estado;

    public UsuarioRolEntity() {
        super();
        this.estado = 1;
    }

    public UsuarioRolEntity(UsuarioEntity usuario, RolEntity rol) {
        super();
        this.usuario = usuario;
        this.rol = rol;
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

    @JoinColumn(name = "USUARIO_ID", referencedColumnName = "ID")
    @ManyToOne()
    public UsuarioEntity getUsuario() {
        return usuario;
    }

    public void setUsuario(UsuarioEntity usuario) {
        this.usuario = usuario;
    }

    @JoinColumn(name = "ROL_ID", referencedColumnName = "ID")
    @ManyToOne()
    public RolEntity getRol() {
        return rol;
    }

    public void setRol(RolEntity rol) {
        this.rol = rol;
    }

    @Basic
    @Column(name = "ESTADO")
    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UsuarioRolEntity that = (UsuarioRolEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(estado, that.estado);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, estado);
    }
}
