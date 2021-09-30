package com.proyecto.BussolaZoe.model;


import com.proyecto.BussolaZoe.login.UsuarioRoles;
import com.sun.istack.NotNull;

import javax.persistence.*;
import javax.validation.constraints.Size;


@Entity
@Table(name = "usuarios")
public class Usuario{

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "usuario_sequence")
    @SequenceGenerator(name = "usuario_sequence", sequenceName = "usuario_sequence")
    private Long id;

    private String nombre;
    private String apellido;

    @NotNull
    @Size(min = 2, max = 10, message = "El usuario debe contener entre 2 y 10 caracteres")
    private String userName;

    @NotNull
    //@Size(min = 2, max = 10, message = "La contraseña debe contener entre 2 y 10 caracteres")
    private String password;

    @Enumerated(EnumType.STRING)
    private UsuarioRoles usuarioRoles;


    public Usuario(String nombre, String apellido, String userName, String password, UsuarioRoles usuarioRoles) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.userName = userName;
        this.password = password;
        this.usuarioRoles = usuarioRoles;
    }

    public Usuario() {
    }

    public Long getId() {
        return id;
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

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public UsuarioRoles getUsuarioRoles() {
        return usuarioRoles;
    }

    public void setUsuarioRoles(UsuarioRoles usuarioRoles) {
        this.usuarioRoles = usuarioRoles;
    }

    @Override
    public String toString() {
        return "Usuario: " +
                "id: " + id + "\n" +
                "Nombre de usuario: '" + userName + "\n" +
                "Contraseña: " + password;
    }

/*
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        SimpleGrantedAuthority grantedAuthority = new SimpleGrantedAuthority(usuarioRoles.name());
        return Collections.singletonList(grantedAuthority);
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return userName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }


 */
}
