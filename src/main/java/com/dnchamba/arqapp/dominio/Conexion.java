package com.dnchamba.arqapp.dominio;

import com.dnchamba.arqapp.rest.model.Ensayo;
import com.dnchamba.arqapp.rest.model.Equipo;
import com.dnchamba.arqapp.rest.model.Laboratorio;
import com.dnchamba.arqapp.rest.model.Reserva;
import com.dnchamba.arqapp.rest.model.Usuario;
import com.dnchamba.arqapp.rest.model.SeccionEnsayo;
import java.util.List;

/**
 *
 * @author Dayana
 */
public interface Conexion {
    List<Usuario> getDatosUsuario();
    public Usuario getDatoUsuario(String usuario, String contrasenia);
    public Usuario obtenerEncargadoDatosLab(int usuario_id_usuario);
//    public Usuario getDatoUsuario(int id_usuario);
    //public int insertDatosUsuario(String cedula, String nombres, String usuario, String contrasenia, int tipo);   
    public Usuario insertDatosUsuario(Usuario usuario);   
    public Usuario updateDatosUsuario(Usuario usuario);   
    public boolean delateDatosUsuario(int id);
    //laboratorio
    List<Laboratorio> getDatosLaboratorio();
    public Laboratorio getDatoLab(int id_laboratorio);
    public Laboratorio insertDatosLab(Laboratorio laboratorio);
    public Laboratorio updateDatosLab(Laboratorio laboratorio);
    public boolean delateDatosLab(int id);   
    //Ensayo
    List<Ensayo> getDatosEnsayo();
    public Ensayo getDatoEnsayo(int id_ensayo);
    public Ensayo insertDatosEnsayo(Ensayo Ensayo);
    public Ensayo updateDatosEnsayo(Ensayo Ensayo);
    public boolean delateDatosEnsayo(int id);   
    //Seccion_Ensayo
    List<SeccionEnsayo> getDatosSeccionEnsayo();
    public SeccionEnsayo getDatoSeccionEnsayo(int id_seccion_ensayo);
    public SeccionEnsayo insertDatosSeccionEnsayo(SeccionEnsayo seccionEnsayo);
    public SeccionEnsayo updateDatosSeccionEnsayo(SeccionEnsayo seccionEnsayo);
    public boolean delateDatosSeccionEnsayo(int id);   
    //Equipo
    List<Equipo> getDatosEquipo();
    public Equipo getDatoEquipo(int id_equipo);
    public Equipo insertDatosEquipo(Equipo equipo);
    public Equipo updateDatosEquipo(Equipo equipo);
    public boolean delateDatosEquipo(int id);   
    //Reserva
    List<Reserva> getDatosReserva();
    public Reserva getDatoReserva(int id_seccion_ensayo);
    public Reserva insertDatosReserva(Reserva reserva);
    public Reserva updateDatosReserva(Reserva reserva);
    public boolean delateDatosReserva(int id);   
    
    
}
