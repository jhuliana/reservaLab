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
public class Reserva {

    private int id_reserva;
    private String titulacion;
    private String periodo_academico;
    private String nivel_academico;
    private String componente;
    private String codigo_proyecto;
    private String tema_practica;
    private String docente;
    private String estudiante;
    private String ciclo;
    private String fecha;
    private String hora;
    private int laboratorio_id_laboratorio;
    private int usuario_id_usuario;

    public Reserva() {
    }

    public Reserva(int id_reserva) {
        this.id_reserva = id_reserva;
    }

    public Reserva(int id_reserva, String titulacion, String periodo_academico, String nivel_academico, String componente, String codigo_proyecto, String tema_practica, String docente, String estudiante, String ciclo, String fecha, String hora, int laboratorio_id_laboratorio, int usuario_id_usuario) {
        this.id_reserva = id_reserva;
        this.titulacion = titulacion;
        this.periodo_academico = periodo_academico;
        this.nivel_academico = nivel_academico;
        this.componente = componente;
        this.codigo_proyecto = codigo_proyecto;
        this.tema_practica = tema_practica;
        this.docente = docente;
        this.estudiante = estudiante;
        this.ciclo = ciclo;
        this.fecha = fecha;
        this.hora = hora;
        this.laboratorio_id_laboratorio = laboratorio_id_laboratorio;
        this.usuario_id_usuario = usuario_id_usuario;
    }

    public int getId_reserva() {
        return id_reserva;
    }

    public void setId_reserva(int id_reserva) {
        this.id_reserva = id_reserva;
    }

    public String getTitulacion() {
        return titulacion;
    }

    public void setTitulacion(String titulacion) {
        this.titulacion = titulacion;
    }

    public String getPeriodo_academico() {
        return periodo_academico;
    }

    public void setPeriodo_academico(String periodo_academico) {
        this.periodo_academico = periodo_academico;
    }

    public String getNivel_academico() {
        return nivel_academico;
    }

    public void setNivel_academico(String nivel_academico) {
        this.nivel_academico = nivel_academico;
    }

    public String getComponente() {
        return componente;
    }

    public void setComponente(String componente) {
        this.componente = componente;
    }

    public String getCodigo_proyecto() {
        return codigo_proyecto;
    }

    public void setCodigo_proyecto(String codigo_proyecto) {
        this.codigo_proyecto = codigo_proyecto;
    }

    public String getTema_practica() {
        return tema_practica;
    }

    public void setTema_practica(String tema_practica) {
        this.tema_practica = tema_practica;
    }

    public String getDocente() {
        return docente;
    }

    public void setDocente(String docente) {
        this.docente = docente;
    }

    public String getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(String estudiante) {
        this.estudiante = estudiante;
    }

    public String getCiclo() {
        return ciclo;
    }

    public void setCiclo(String ciclo) {
        this.ciclo = ciclo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public int getLaboratorio_id_laboratorio() {
        return laboratorio_id_laboratorio;
    }

    public void setLaboratorio_id_laboratorio(int laboratorio_id_laboratorio) {
        this.laboratorio_id_laboratorio = laboratorio_id_laboratorio;
    }

    public int getUsuario_id_usuario() {
        return usuario_id_usuario;
    }

    public void setUsuario_id_usuario(int usuario_id_usuario) {
        this.usuario_id_usuario = usuario_id_usuario;
    }
}
