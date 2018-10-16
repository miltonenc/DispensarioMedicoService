package com.mencarnacion.model.dto;

import java.util.Objects;

public class UsuarioRolDTO {
    private Long id;
    private String codigo;
    private String rol;

    public UsuarioRolDTO() {
        super();
    }

    public UsuarioRolDTO(Long id, String codigo, String rol) {
        this.id = id;
        this.codigo = codigo;
        this.rol = rol;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UsuarioRolDTO that = (UsuarioRolDTO) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(codigo, that.codigo) &&
                Objects.equals(rol, that.rol);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, codigo, rol);
    }
}
