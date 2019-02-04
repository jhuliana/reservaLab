/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dnchamba.arqapp.rest.dao;

import com.dnchamba.arqapp.dominio.Conexion;
import com.dnchamba.arqapp.rest.model.Equipo;
import java.util.List;
/**
 *
 * @author Jhuliana
 */
public class EquipoDAO {
    private static Conexion usuarios;

    public EquipoDAO() {
    }

    public EquipoDAO(Conexion usuarios) {
        this.usuarios = usuarios;
    }
    
    public List<Equipo> getDatosEquipo() {
        return usuarios.getDatosEquipo();
    }

    public Equipo getEquipo(int id) {
        return usuarios.getDatoEquipo(id);
    }

    public Equipo insertarEquipo(Equipo equipo) {
        usuarios.insertDatosEquipo(equipo);
        return equipo;
    }

    public Equipo updateEquipo(Equipo equipo) {

        usuarios.updateDatosEquipo(equipo);

        return equipo;
    }
    
    public boolean deleteEquipo(int id) {

        if (usuarios.delateDatosEquipo(id)) {
            return true;
        } else {
            return false;
        }

    }
}
