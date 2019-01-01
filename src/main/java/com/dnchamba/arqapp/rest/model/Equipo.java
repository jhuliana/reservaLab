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
public class Equipo {
    private int id_equipo;
    private String nombre_equipo;
    private String descripcion;
    private char estado;
    private int cantidad;
    private int laboratorio_id_laboratorio;
    private int laboratorio_encargado_lab_id_encargado_lab;

    public Equipo() {
    }

    public Equipo(int id_equipo, String nombre_equipo, String descripcion, char estado, int cantidad, int laboratorio_id_laboratorio, int laboratorio_encargado_lab_id_encargado_lab) {
        this.id_equipo = id_equipo;
        this.nombre_equipo = nombre_equipo;
        this.descripcion = descripcion;
        this.estado = estado;
        this.cantidad = cantidad;
        this.laboratorio_id_laboratorio = laboratorio_id_laboratorio;
        this.laboratorio_encargado_lab_id_encargado_lab = laboratorio_encargado_lab_id_encargado_lab;
    }

    public int getId_equipo() {
        return id_equipo;
    }

    public void setId_equipo(int id_equipo) {
        this.id_equipo = id_equipo;
    }

    public String getNombre_equipo() {
        return nombre_equipo;
    }

    public void setNombre_equipo(String nombre_equipo) {
        this.nombre_equipo = nombre_equipo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public char getEstado() {
        return estado;
    }

    public void setEstado(char estado) {
        this.estado = estado;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getLaboratorio_id_laboratorio() {
        return laboratorio_id_laboratorio;
    }

    public void setLaboratorio_id_laboratorio(int laboratorio_id_laboratorio) {
        this.laboratorio_id_laboratorio = laboratorio_id_laboratorio;
    }

    public int getLaboratorio_encargado_lab_id_encargado_lab() {
        return laboratorio_encargado_lab_id_encargado_lab;
    }

    public void setLaboratorio_encargado_lab_id_encargado_lab(int laboratorio_encargado_lab_id_encargado_lab) {
        this.laboratorio_encargado_lab_id_encargado_lab = laboratorio_encargado_lab_id_encargado_lab;
    }
    
    
    
    
    
    
    
    
}
