package com.mencarnacion.model.rest.request;

/**
 * Created by mencarnacion on 9/4/18.
 */
public class UsuarioRequest {

    private Long id;
    private String usuario;
    private String password;

    public UsuarioRequest() {
        super();
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
}
