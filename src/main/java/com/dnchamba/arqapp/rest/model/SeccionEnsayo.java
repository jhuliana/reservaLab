/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dnchamba.arqapp.rest.model;
/**
 *
 * @author Jhuliana
 */
public class SeccionEnsayo {
    private int id_seccion_ensayo;
    private String nombre;

    public SeccionEnsayo() {
    }

    public SeccionEnsayo(int id_seccion_ensayo, String nombre) {
        this.id_seccion_ensayo = id_seccion_ensayo;
        this.nombre = nombre;
    }

    public SeccionEnsayo(int id_seccion_ensayo) {
        this.id_seccion_ensayo = id_seccion_ensayo;
    }

    public int getId_seccion_ensayo() {
        return id_seccion_ensayo;
    }

    public void setId_seccion_ensayo(int id_seccion_ensayo) {
        this.id_seccion_ensayo = id_seccion_ensayo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
