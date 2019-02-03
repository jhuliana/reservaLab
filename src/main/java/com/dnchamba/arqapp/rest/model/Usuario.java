package com.dnchamba.arqapp.rest.model;

/**
 *
 * @author Dayana
 */
public class Usuario {
     private int id_usuario;
    private String cedula;
    private String nombres;
    private String usuario;
    private String contrasenia;
    private int tipo;

    public Usuario() {
    }

    public Usuario(int id_usuario, String cedula, String nombres, String usuario, String contrasenia, int tipo) {
        this.id_usuario = id_usuario;
        this.cedula = cedula;
        this.nombres = nombres;
        this.usuario = usuario;
        this.contrasenia = contrasenia;
        this.tipo = tipo;
    }

    public Usuario(int id_usuario, String nombres) {
        this.id_usuario = id_usuario;
        this.nombres = nombres;
    }
    
    public Usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public Usuario(int id_usuario, String usuario, String contrasenia, int tipo) {
        this.id_usuario = id_usuario;
        this.usuario = usuario;
        this.contrasenia = contrasenia;
        this.tipo = tipo;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContrasenia() {
        return contrasenia;
    }

    public void setContrasenia(String contrasenia) {
        this.contrasenia = contrasenia;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }
   

    
    
}
