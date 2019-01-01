/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dnchamba.arqapp.rest.dao;

import com.dnchamba.arqapp.dominio.Conexion;
import com.dnchamba.arqapp.rest.model.Laboratorio;
import java.util.List;

/**
 *
 * @author Jhuliana
 */
public class LaboratorioDAO {

    private static Conexion usuarios;

    public LaboratorioDAO(Conexion usuarios) {
        this.usuarios = usuarios;
    }

    public List<Laboratorio> getDatosLaboratorio() {
        return usuarios.getDatosLaboratorio();
    }

    public Laboratorio getLaboratorio(int id) {
        return usuarios.getDatoLab(id);
    }

    public Laboratorio insertarLaboratorio(Laboratorio laboratorio) {
        usuarios.insertDatosLab(laboratorio);
        return laboratorio;
    }

    public Laboratorio updateLaboratorio(Laboratorio laboratorio) {

        usuarios.updateDatosLab(laboratorio);

        return laboratorio;
    }
    
    public boolean deleteLaboratorio(int id) {

        if (usuarios.delateDatosLab(id)) {
            return true;
        } else {
            return false;
        }

    }

}
