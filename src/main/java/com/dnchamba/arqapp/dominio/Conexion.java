package com.dnchamba.arqapp.dominio;

import com.dnchamba.arqapp.rest.model.Ensayo;
import com.dnchamba.arqapp.rest.model.Laboratorio;
import com.dnchamba.arqapp.rest.model.Usuario;
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
    /*public Ensayo getDatoEnsayo(int id_ensayo);
    public Ensayo insertDatosEnsayo(Ensayo Ensayo);
    public Ensayo updateDatosEnsayo(Ensayo Ensayo);
    public boolean delateDatosEnsayo(int id);   */
    
    
}
