/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dnchamba.arqapp.rest.dao;

import com.dnchamba.arqapp.dominio.Conexion;
import com.dnchamba.arqapp.rest.model.Ensayo;
import java.util.List;

/**
 *
 * @author Jhuliana
 */
public class EnsayoDAO {
    private static Conexion usuarios;

    public EnsayoDAO(Conexion usuarios) {
        this.usuarios = usuarios;
    }
    
    public List<Ensayo> getDatosEnsayo() {
        return usuarios.getDatosEnsayo();
    }

    public Ensayo getEnsayo(int id) {
        return usuarios.getDatoEnsayo(id);
    }

    public Ensayo insertarEnsayo(Ensayo ensayo) {
        usuarios.insertDatosEnsayo(ensayo);
        return ensayo;
    }

    public Ensayo updateEnsayo(Ensayo ensayo) {

        usuarios.updateDatosEnsayo(ensayo);

        return ensayo;
    }
    
    public boolean deleteEnsayo(int id) {

        if (usuarios.delateDatosEnsayo(id)) {
            return true;
        } else {
            return false;
        }

    }

}
