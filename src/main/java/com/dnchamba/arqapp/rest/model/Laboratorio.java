package com.dnchamba.arqapp.rest.model;

/**
 *
 * @author Dayana
 */
public class Laboratorio {
    private int id_laboratorio;
    private String nombre;
    private String descripcion;
    private int usuario_id_usuario;
    private String nombre_usuario;
    private String email;

    
    public Laboratorio() {
    }

    public Laboratorio(int id_laboratorio) {
        this.id_laboratorio = id_laboratorio;
    }
    public Laboratorio(int id_laboratorio, String nombre, String descripcion,String nombre_usuario, String email) {
        this.id_laboratorio = id_laboratorio;
        this.nombre = nombre;
        this.descripcion = descripcion;   
        this.email = email;
        this.nombre_usuario = nombre_usuario;
    }
    
     public Laboratorio(int id_laboratorio, String nombre, String descripcion, int usuario_id_usuario) {
        this.id_laboratorio = id_laboratorio;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.usuario_id_usuario = usuario_id_usuario;
    }

    public Laboratorio(String nombre, String descripcion, int usuario_id_usuario) {
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.usuario_id_usuario = usuario_id_usuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public int getId_laboratorio() {
        return id_laboratorio;
    }

    public void setId_laboratorio(int id_laboratorio) {
        this.id_laboratorio = id_laboratorio;
    }
    
    public String getNombre_usuario() {
        return nombre_usuario;
    }

    public void setNombre_usuario(String nombre_usuario) {
        this.nombre_usuario = nombre_usuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getUsuario_id_usuario() {
        return usuario_id_usuario;
    }

    public void setUsuario_id_usuario(int usuario_id_usuario) {
        this.usuario_id_usuario = usuario_id_usuario;
    }
    
}
