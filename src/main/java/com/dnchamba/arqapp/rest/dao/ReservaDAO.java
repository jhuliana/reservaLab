/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dnchamba.arqapp.rest.dao;

import com.dnchamba.arqapp.dominio.Conexion;
import com.dnchamba.arqapp.rest.model.Ensayo;
import com.dnchamba.arqapp.rest.model.Reserva;
import java.util.List;

/**
 *
 * @author Jhuliana
 */
public class ReservaDAO {
        private static Conexion usuarios;

    public ReservaDAO(Conexion usuarios) {
        this.usuarios = usuarios;
    }
    
    public List<Reserva> getDatosReserva() {
        return usuarios.getDatosReserva();
    }

    public Reserva getReserva(int id) {
        return usuarios.getDatoReserva(id);
    }

    public Reserva insertarReserva(Reserva reserva) {
        usuarios.insertDatosReserva(reserva);
        return reserva;
    }

    public Reserva updateReserva(Reserva reserva) {

        usuarios.updateDatosReserva(reserva);

        return reserva;
    }
    
    public boolean deleteReserva(int id) {

        if (usuarios.delateDatosReserva(id)) {
            return true;
        } else {
            return false;
        }

    }

}
