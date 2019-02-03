
package com.dnchamba.arqapp.rest.dao;

import com.dnchamba.arqapp.dominio.Conexion;
import com.dnchamba.arqapp.rest.model.SeccionEnsayo;
import java.util.List;
import java.util.Optional;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jhuliana
 */
public class SeccionEnsayoDAO {
    private static Conexion usuarios;

    public SeccionEnsayoDAO(Conexion usuarios) {
        this.usuarios = usuarios;
    }
    
    public List<SeccionEnsayo> getDatosSeccionEnsayo() {
        return usuarios.getDatosSeccionEnsayo();
    }

    public SeccionEnsayo getSeccionEnsayo(int id) {
        return usuarios.getDatoSeccionEnsayo(id);
    }

    public SeccionEnsayo insertarSeccionEnsayo(SeccionEnsayo seccionEnsayo) {
        usuarios.insertDatosSeccionEnsayo(seccionEnsayo);
        return seccionEnsayo;
    }

    public SeccionEnsayo updateEnsayo(SeccionEnsayo seccionEnsayo) {

        usuarios.updateDatosSeccionEnsayo(seccionEnsayo);

        return seccionEnsayo;
    }
    
    public boolean deleteSeccionEnsayo(int id) {

        if (usuarios.delateDatosSeccionEnsayo(id)) {
            return true;
        } else {
            return false;
        }

    }
}