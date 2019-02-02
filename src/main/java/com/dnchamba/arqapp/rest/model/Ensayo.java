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
public class Ensayo {
    private int id_ensayos;
    private String descripcion;
    private String norma_nacional;
    private String norma_internacional;
    private int seccion_ensayo_id_seccion_ensayo;
    private int laboratorio_id_laboratorio;

    public Ensayo() {
    }

    public Ensayo(int id_ensayos, String descripcion, String norma_nacional, String norma_internacional, int seccion_ensayo_id_seccion_ensayo, int laboratorio_id_laboratorio) {
        this.id_ensayos = id_ensayos;
        this.descripcion = descripcion;
        this.norma_nacional = norma_nacional;
        this.norma_internacional = norma_internacional;
        this.seccion_ensayo_id_seccion_ensayo = seccion_ensayo_id_seccion_ensayo;
        this.laboratorio_id_laboratorio = laboratorio_id_laboratorio;
    }

    public Ensayo(int id_ensayos) {
        this.id_ensayos = id_ensayos;
    }
    

    public int getId_ensayos() {
        return id_ensayos;
    }

    public void setId_ensayos(int id_ensayos) {
        this.id_ensayos = id_ensayos;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNorma_nacional() {
        return norma_nacional;
    }

    public void setNorma_nacional(String norma_nacional) {
        this.norma_nacional = norma_nacional;
    }

    public String getNorma_internacional() {
        return norma_internacional;
    }

    public void setNorma_internacional(String norma_internacional) {
        this.norma_internacional = norma_internacional;
    }

    public int getSeccion_ensayo_id_seccion_ensayo() {
        return seccion_ensayo_id_seccion_ensayo;
    }

    public void setSeccion_ensayo_id_seccion_ensayo(int seccion_ensayo_id_seccion_ensayo) {
        this.seccion_ensayo_id_seccion_ensayo = seccion_ensayo_id_seccion_ensayo;
    }

    public int getLaboratorio_id_laboratorio() {
        return laboratorio_id_laboratorio;
    }

    public void setLaboratorio_id_laboratorio(int laboratorio_id_laboratorio) {
        this.laboratorio_id_laboratorio = laboratorio_id_laboratorio;
    }    
}
