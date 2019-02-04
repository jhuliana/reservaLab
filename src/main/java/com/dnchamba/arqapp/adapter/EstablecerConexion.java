package com.dnchamba.arqapp.adapter;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dayana
 */
public class EstablecerConexion {
       private Connection con;
       private static EstablecerConexion establecerCon;
       

    private EstablecerConexion(Connection con) {
        this.con = con;
    }

    public static EstablecerConexion getSingletonInstance(Connection con){
        if (establecerCon == null) {
            establecerCon = new EstablecerConexion(con);
        }else{
            System.out.println("No se puede crear la conexión, porque ya existe esa conexion");
        }
        return establecerCon;
    }

    public Connection getCon() {
        return con;
    }

    public void setCon(Connection con) {
        this.con = con;
    }    
    
    @Override
    public EstablecerConexion clone(){
        try{
            throw new CloneNotSupportedException();
        }catch (CloneNotSupportedException ex){
            System.out.println("No se puede clonar un objeto de la clase EstablecerConexion");
        }
        return null;
    }   
}
