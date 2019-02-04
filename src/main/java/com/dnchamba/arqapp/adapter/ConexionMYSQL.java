package com.dnchamba.arqapp.adapter;

import com.dnchamba.arqapp.dominio.Conexion;
import com.dnchamba.arqapp.rest.model.Ensayo;
import com.dnchamba.arqapp.rest.model.Equipo;
import com.dnchamba.arqapp.rest.model.Laboratorio;
import com.dnchamba.arqapp.rest.model.Reserva;
import com.dnchamba.arqapp.rest.model.SeccionEnsayo;
import com.dnchamba.arqapp.rest.model.Usuario;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Dayana
 */
public class ConexionMYSQL implements Conexion {

    public EstablecerConexion con = new EstablecerConexion();

    private final String tabla = "usuario";

    @Override
    public List<Usuario> getDatosUsuario() {
        List<Usuario> usuario = new ArrayList<>();
        try {
            PreparedStatement consulta = con.getConnection().prepareStatement("SELECT Id_usuario, cedula, nombres, usuario, contrasenia, tipo, email FROM usuario");
            ResultSet resultado = consulta.executeQuery();
            while (resultado.next()) {
                usuario.add(new Usuario(resultado.getInt("Id_usuario"), resultado.getString("cedula"), resultado.getString("nombres"), resultado.getString("usuario"), resultado.getString("contrasenia"), resultado.getInt("tipo"), resultado.getString("email")));
            }
        } catch (SQLException ex) {
            try {
                throw new SQLException(ex);
            } catch (SQLException ex1) {
                Logger.getLogger(ConexionMYSQL.class.getName()).log(Level.SEVERE, null, ex1);
            }

        }

        return usuario;
    }

    @Override
    public Usuario getDatoUsuario(String usuario, String contrasenia) {
        Usuario usuarioRegistrado = new Usuario();
        try {
            PreparedStatement consulta = con.getConnection().prepareStatement("SELECT id_usuario, usuario, contrasenia, tipo FROM usuario WHERE usuario = '" + usuario + "' AND contrasenia = '" + contrasenia + "'");
            ResultSet resultado = consulta.executeQuery();
            while (resultado.next()) {
                usuarioRegistrado = new Usuario(resultado.getInt("id_usuario"), resultado.getString("usuario"), resultado.getString("contrasenia"), resultado.getInt("tipo"));
            }
        } catch (SQLException ex) {
            try {
                throw new SQLException(ex);
            } catch (SQLException ex1) {
                Logger.getLogger(ConexionMYSQL.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
        return usuarioRegistrado;
    }

    @Override
    public Usuario insertDatosUsuario(Usuario usuario) {
        try {
            PreparedStatement consulta = con.getConnection().prepareStatement("INSERT INTO usuario(cedula, nombres, usuario, contrasenia, tipo,email)"
                    + "VALUES (?,?,?,?,?,?)");
            consulta.setString(1, usuario.getCedula());
            consulta.setString(2, usuario.getNombres());
            consulta.setString(3, usuario.getUsuario());
            consulta.setString(4, usuario.getContrasenia());
            consulta.setInt(5, usuario.getTipo());
            consulta.setString(6, usuario.getEmail());
            consulta.executeUpdate();

        } catch (SQLException ex) {
            Logger.getLogger(ConexionMYSQL.class.getName()).log(Level.SEVERE, null, ex);

        }
        return usuario;
    }

    public Usuario updateDatosUsuario(Usuario usuario) {
        try {
            PreparedStatement consulta = con.getConnection().prepareStatement("UPDATE usuario SET cedula=?, nombres=?, usuario=?, contrasenia=?, tipo=? WHERE id_usuario = ?");
            consulta.setString(1, usuario.getCedula());
            consulta.setString(2, usuario.getNombres());
            consulta.setString(3, usuario.getUsuario());
            consulta.setString(4, usuario.getContrasenia());
            consulta.setInt(5, usuario.getTipo());
            consulta.setInt(6, usuario.getId_usuario());
            consulta.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ConexionMYSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return usuario;
    }

    /*@Override
    public Usuario getDatoUsuario(int id_usuario) {
        Usuario usuarioRegistrado = new Usuario();
        try {
            PreparedStatement consulta = con.getConnection().prepareStatement("Id_usuario, cedula, nombres, usuario, contrasenia, tipo FROM usuario WHERE id_usuario = '" + id_usuario + "'");
            ResultSet resultado = consulta.executeQuery();
            while (resultado.next()) {
                usuarioRegistrado = new Usuario(resultado.getInt("id_usuario"));
            }
        } catch (SQLException ex) {
            try {
                throw new SQLException(ex);
            } catch (SQLException ex1) {
                Logger.getLogger(ConexionMYSQL.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
        return usuarioRegistrado;
    }*/
    @Override
    public boolean delateDatosUsuario(int id) {
        try {
            PreparedStatement consulta = con.getConnection().prepareStatement("DELETE FROM usuario WHERE id_usuario = ?");
            consulta.setInt(1, id);
            consulta.executeUpdate();
            if (consulta.executeUpdate() == 1) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConexionMYSQL.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;

    }

    /*LABORATORIO*/
    public List<Laboratorio> getDatosLaboratorio() {
        List<Laboratorio> laboratorio = new ArrayList<>();
        try {
            PreparedStatement consulta = con.getConnection().prepareStatement("SELECT id_laboratorio, nombre, descripcion, us.nombres AS nom_usuario, us.mail AS mail FROM laboratorio lab, usuario us WHERE lab.usuario_id_usuario = us.id_usuario");
            ResultSet resultado = consulta.executeQuery();
            while (resultado.next()) {
                laboratorio.add(new Laboratorio(resultado.getInt("id_laboratorio"), resultado.getString("nombre"), resultado.getString("descripcion"), resultado.getString("nom_usuario"), resultado.getString("mail")));
            }
        } catch (SQLException ex) {
            try {
                throw new SQLException(ex);
            } catch (SQLException ex1) {
                Logger.getLogger(ConexionMYSQL.class.getName()).log(Level.SEVERE, null, ex1);
            }

        }
        return laboratorio;
    }

    public Laboratorio insertDatosLab(Laboratorio laboratorio) {
        try {
            PreparedStatement consulta = con.getConnection().prepareStatement("INSERT INTO laboratorio(nombre, descripcion, usuario_id_usuario)"
                    + "VALUES (?,?,?)");
            consulta.setString(1, laboratorio.getNombre());
            consulta.setString(2, laboratorio.getDescripcion());
            consulta.setInt(3, laboratorio.getUsuario_id_usuario());
            consulta.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ConexionMYSQL.class.getName()).log(Level.SEVERE, null, ex);

        }
        return laboratorio;
    }

    /*public Usuario updateDatosUsuario(Usuario usuario) {
        try {
            PreparedStatement consulta = con.getConnection().prepareStatement("UPDATE usuario SET cedula=?, nombres=?, usuario=?, contrasenia=?, tipo=? WHERE id_usuario = ?");
            consulta.setString(1, usuario.getCedula());
            consulta.setString(2, usuario.getNombres());
            consulta.setString(3, usuario.getUsuario());
            consulta.setString(4, usuario.getContrasenia());
            consulta.setInt(5, usuario.getTipo());
            consulta.setInt(6, usuario.getId_usuario());
            consulta.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ConexionMYSQL.class.getName()).log(Level.SEVERE, null, ex);
        }
        return usuario;
    }*/
    @Override
    public Laboratorio updateDatosLab(Laboratorio laboratorio) {
        try {
            PreparedStatement consulta = con.getConnection().prepareStatement("UPDATE laboratorio SET nombre=?, descripcion=?, usuario_id_usuario=? WHERE id_laboratorio = ?");
            consulta.setString(1, laboratorio.getNombre());
            consulta.setString(2, laboratorio.getDescripcion());
            consulta.setInt(3, laboratorio.getUsuario_id_usuario());
            consulta.setInt(4, laboratorio.getId_laboratorio());
            consulta.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ConexionMYSQL.class.getName()).log(Level.SEVERE, null, ex);
        }

        return laboratorio;
    }

    @Override
    public boolean delateDatosLab(int id) {
        try {
            PreparedStatement consulta = con.getConnection().prepareStatement("DELETE FROM laboratorio WHERE id_laboratorio = ?");
            consulta.setInt(1, id);
            consulta.executeUpdate();
            if (consulta.executeUpdate() == 1) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConexionMYSQL.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;

    }

    @Override
    public Laboratorio getDatoLab(int id_laboratorio) {
        Laboratorio laboratorioRegistrado = new Laboratorio();
        try {
            PreparedStatement consulta = con.getConnection().prepareStatement("SELECT id_laboratorio, nombre, descripcion, us.nombres AS nom_usuario, us.mail AS mail FROM laboratorio lab, usuario us WHERE lab.usuario_id_usuario = us.id_usuario AND lab.id_laboratorio = " + id_laboratorio);
            ResultSet resultado = consulta.executeQuery();
            while (resultado.next()) {
                laboratorioRegistrado = new Laboratorio(resultado.getInt("id_laboratorio"), resultado.getString("nombre"), resultado.getString("descripcion"), resultado.getString("nom_usuario"), resultado.getString("mail"));
            }
        } catch (SQLException ex) {
            try {
                throw new SQLException(ex);
            } catch (SQLException ex1) {
                Logger.getLogger(ConexionMYSQL.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
        return laboratorioRegistrado;
    }

    @Override
    public Usuario obtenerEncargadoDatosLab(int id_usuario_id_usuario) {
        Usuario usuarioRegistrado = new Usuario();
        try {
            PreparedStatement consulta = con.getConnection().prepareStatement("SELECT us.nombres FROM usuario us, laboratorio lab WHERE us.id_usuario = " + id_usuario_id_usuario);
            ResultSet resultado = consulta.executeQuery();
            while (resultado.next()) {
                usuarioRegistrado = new Usuario(resultado.getInt("id_usuario"), resultado.getString("nombres"));

            }
        } catch (SQLException ex) {
            try {
                throw new SQLException(ex);
            } catch (SQLException ex1) {
                Logger.getLogger(ConexionMYSQL.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
        return usuarioRegistrado;

    }

    //Ensayo
    @Override
    public List<Ensayo> getDatosEnsayo() {
        List<Ensayo> ensayo = new ArrayList<>();
        try {
            PreparedStatement consulta = con.getConnection().prepareStatement("SELECT `id_ensayos`, `descripcion`, `norma_nacional`,`norma_internacional`,`seccion_ensayo_id_seccion_ensayo`,`laboratorio_id_laboratorio` FROM `ensayos`");
            ResultSet resultado = consulta.executeQuery();
            while (resultado.next()) {
                ensayo.add(new Ensayo(resultado.getInt("id_ensayos"), resultado.getString("descripcion"), resultado.getString("norma_nacional"), resultado.getString("norma_internacional"), resultado.getInt("seccion_ensayo_id_seccion_ensayo"), resultado.getInt("laboratorio_id_laboratorio")));
            }
        } catch (SQLException ex) {
            try {
                throw new SQLException(ex);
            } catch (SQLException ex1) {
                Logger.getLogger(ConexionMYSQL.class.getName()).log(Level.SEVERE, null, ex1);
            }

        }
        return ensayo;
    }

    @Override
    public Ensayo getDatoEnsayo(int id_ensayo) {
        Ensayo ensayoRegistrado = new Ensayo();
        try {
            PreparedStatement consulta = con.getConnection().prepareStatement("SELECT id_ensayos, descripcion, norma_nacional, norma_internacional, seccion_ensayo_id_seccion_ensayo, laboratorio_id_laboratorio FROM ensayos WHERE id_ensayos = " + id_ensayo);
            ResultSet resultado = consulta.executeQuery();
            while (resultado.next()) {
                ensayoRegistrado = new Ensayo(resultado.getInt("id_ensayos"), resultado.getString("descripcion"), resultado.getString("norma_nacional"), resultado.getString("norma_internacional"), resultado.getInt("seccion_ensayo_id_seccion_ensayo"), resultado.getInt("laboratorio_id_laboratorio"));
            }
        } catch (SQLException ex) {
            try {
                throw new SQLException(ex);
            } catch (SQLException ex1) {
                Logger.getLogger(ConexionMYSQL.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
        return ensayoRegistrado;
    }

    @Override
    public Ensayo insertDatosEnsayo(Ensayo ensayo) {
        try {
            PreparedStatement consulta = con.getConnection().prepareStatement("INSERT INTO ensayos(descripcion, norma_nacional, norma_internacional,seccion_ensayo_id_seccion_ensayo,laboratorio_id_laboratorio)"
                    + "VALUES (?,?,?,?,?)");
            consulta.setString(1, ensayo.getDescripcion());
            consulta.setString(2, ensayo.getNorma_nacional());
            consulta.setString(3, ensayo.getNorma_internacional());
            consulta.setInt(4, ensayo.getSeccion_ensayo_id_seccion_ensayo());
            consulta.setInt(5, ensayo.getLaboratorio_id_laboratorio());
            consulta.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ConexionMYSQL.class.getName()).log(Level.SEVERE, null, ex);

        }
        return ensayo;
    }

    @Override
    public Ensayo updateDatosEnsayo(Ensayo ensayo) {
        try {
            PreparedStatement consulta = con.getConnection().prepareStatement("UPDATE ensayos SET descripcion=?, norma_nacional=?, norma_internacional=?, seccion_ensayo_id_seccion_ensayo=?,laboratorio_id_laboratorio=? WHERE id_ensayos = ?");
            consulta.setString(1, ensayo.getDescripcion());
            consulta.setString(2, ensayo.getNorma_nacional());
            consulta.setString(3, ensayo.getNorma_internacional());
            consulta.setInt(4, ensayo.getSeccion_ensayo_id_seccion_ensayo());
            consulta.setInt(5, ensayo.getLaboratorio_id_laboratorio());
            consulta.setInt(6, ensayo.getId_ensayos());
            consulta.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ConexionMYSQL.class.getName()).log(Level.SEVERE, null, ex);
        }

        return ensayo;
    }

    @Override
    public boolean delateDatosEnsayo(int id) {
        try {
            PreparedStatement consulta = con.getConnection().prepareStatement("DELETE FROM ensayos WHERE id_ensayos = ?");
            consulta.setInt(1, id);
            consulta.executeUpdate();
            if (consulta.executeUpdate() == 1) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConexionMYSQL.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

    @Override
    public List<SeccionEnsayo> getDatosSeccionEnsayo() {
        List<SeccionEnsayo> seccionEnsayo = new ArrayList<>();
        try {
            PreparedStatement consulta = con.getConnection().prepareStatement("SELECT * FROM seccion_ensayo");
            ResultSet resultado = consulta.executeQuery();
            while (resultado.next()) {
                seccionEnsayo.add(new SeccionEnsayo(resultado.getInt("id_seccion_ensayo"), resultado.getString("nombre")));
            }
        } catch (SQLException ex) {
            try {
                throw new SQLException(ex);
            } catch (SQLException ex1) {
                Logger.getLogger(ConexionMYSQL.class.getName()).log(Level.SEVERE, null, ex1);
            }

        }
        return seccionEnsayo;
    }

    @Override
    public SeccionEnsayo getDatoSeccionEnsayo(int id_seccion_ensayo) {
        SeccionEnsayo seccionEnsayoRegistrado = new SeccionEnsayo();
        try {
            PreparedStatement consulta = con.getConnection().prepareStatement("SELECT id_seccion_ensayo, nombre FROM seccion_ensayo WHERE id_seccion_ensayo = " + id_seccion_ensayo);
            ResultSet resultado = consulta.executeQuery();
            while (resultado.next()) {
                seccionEnsayoRegistrado = new SeccionEnsayo(resultado.getInt("id_seccion_ensayo"), resultado.getString("nombre"));
            }
        } catch (SQLException ex) {
            try {
                throw new SQLException(ex);
            } catch (SQLException ex1) {
                Logger.getLogger(ConexionMYSQL.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
        return seccionEnsayoRegistrado;
    }

    @Override
    public SeccionEnsayo insertDatosSeccionEnsayo(SeccionEnsayo seccionEnsayo) {
        try {
            PreparedStatement consulta = con.getConnection().prepareStatement("INSERT INTO seccion_ensayo(id_seccion_ensayo, nombre)"
                    + "VALUES (?,?)");
            consulta.setInt(1, seccionEnsayo.getId_seccion_ensayo());
            consulta.setString(2, seccionEnsayo.getNombre());
            consulta.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ConexionMYSQL.class.getName()).log(Level.SEVERE, null, ex);

        }
        return seccionEnsayo;
    }

    @Override
    public SeccionEnsayo updateDatosSeccionEnsayo(SeccionEnsayo seccionEnsayo) {
        try {
            PreparedStatement consulta = con.getConnection().prepareStatement("UPDATE seccion_ensayo SET nombre=? WHERE id_seccion_ensayo = ?");
            consulta.setString(1, seccionEnsayo.getNombre());
            consulta.setInt(2, seccionEnsayo.getId_seccion_ensayo());
            consulta.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ConexionMYSQL.class.getName()).log(Level.SEVERE, null, ex);
        }

        return seccionEnsayo;
    }

    @Override
    public boolean delateDatosSeccionEnsayo(int id) {
        try {
            PreparedStatement consulta = con.getConnection().prepareStatement("DELETE FROM seccion_ensayo WHERE id_seccion_ensayo = ?");
            consulta.setInt(1, id);
            consulta.executeUpdate();
            if (consulta.executeUpdate() == 1) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConexionMYSQL.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

    //Equipo
    @Override
    public List<Equipo> getDatosEquipo() {
        List<Equipo> equipo = new ArrayList<>();
        try {
            PreparedStatement consulta = con.getConnection().prepareStatement("SELECT `id_equipo`, `nombre_equipo`, `descripcion`,`estado`,`cantidad`,`laboratorio_id_laboratorio`,`laboratorio_encargado_lab_id_encargado_lab` FROM `equipo`");
            ResultSet resultado = consulta.executeQuery();
            while (resultado.next()) {
                equipo.add(new Equipo(resultado.getInt("id_equipo"), resultado.getString("nombre_equipo"), resultado.getString("descripcion"), resultado.getBoolean("estado"), resultado.getInt("cantidad"), resultado.getInt("laboratorio_id_laboratorio"), resultado.getInt("laboratorio_encargado_lab_id_encargado_lab")));
            }
        } catch (SQLException ex) {
            try {
                throw new SQLException(ex);
            } catch (SQLException ex1) {
                Logger.getLogger(ConexionMYSQL.class.getName()).log(Level.SEVERE, null, ex1);
            }

        }
        return equipo;
    }

    @Override
    public Equipo getDatoEquipo(int id_equipo) {
        Equipo equipoRegistrado = new Equipo();
        try {
            PreparedStatement consulta = con.getConnection().prepareStatement("SELECT `id_equipo`, `nombre_equipo`, `descripcion`,`estado`,`cantidad`,`laboratorio_id_laboratorio`,`laboratorio_encargado_lab_id_encargado_lab` FROM equipo WHERE id_equipo = " + id_equipo);
            ResultSet resultado = consulta.executeQuery();
            while (resultado.next()) {
                equipoRegistrado = new Equipo(resultado.getInt("id_equipo"), resultado.getString("nombre_equipo"), resultado.getString("descripcion"), resultado.getBoolean("estado"), resultado.getInt("cantidad"), resultado.getInt("laboratorio_id_laboratorio"), resultado.getInt("laboratorio_encargado_lab_id_encargado_lab"));
            }
        } catch (SQLException ex) {
            try {
                throw new SQLException(ex);
            } catch (SQLException ex1) {
                Logger.getLogger(ConexionMYSQL.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
        return equipoRegistrado;
    }

    @Override
    public Equipo insertDatosEquipo(Equipo equipo) {
        try {
            PreparedStatement consulta = con.getConnection().prepareStatement("INSERT INTO equipo(`id_equipo`, `nombre_equipo`, `descripcion`,`estado`,`cantidad`,`laboratorio_id_laboratorio`,`laboratorio_encargado_lab_id_encargado_lab`)"
                    + "VALUES (?,?,?,?,?,?,?)");
            consulta.setInt(1, equipo.getId_equipo());
            consulta.setString(2, equipo.getNombre_equipo());
            consulta.setString(3, equipo.getDescripcion());
            consulta.setBoolean(4, equipo.getEstado());
            consulta.setInt(5, equipo.getCantidad());
            consulta.setInt(6, equipo.getLaboratorio_id_laboratorio());
            consulta.setInt(7, equipo.getLaboratorio_encargado_lab_id_encargado_lab());
            consulta.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ConexionMYSQL.class.getName()).log(Level.SEVERE, null, ex);

        }
        return equipo;
    }

    @Override
    public Equipo updateDatosEquipo(Equipo equipo) {
        try {
            PreparedStatement consulta = con.getConnection().prepareStatement("UPDATE equipo SET nombre_equipo=?, descripcion=?, estado=?, cantidad=?,laboratorio_id_laboratorio=?, laboratorio_encargado_lab_id_encargado_lab=? WHERE id_equipo = ?");
            consulta.setString(1, equipo.getNombre_equipo());
            consulta.setString(2, equipo.getDescripcion());
            consulta.setBoolean(3, equipo.getEstado());
            consulta.setInt(4, equipo.getCantidad());
            consulta.setInt(5, equipo.getLaboratorio_id_laboratorio());
            consulta.setInt(6, equipo.getLaboratorio_encargado_lab_id_encargado_lab());
            consulta.setInt(7, equipo.getId_equipo());
            consulta.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ConexionMYSQL.class.getName()).log(Level.SEVERE, null, ex);
        }

        return equipo;
    }

    @Override
    public boolean delateDatosEquipo(int id) {
        try {
            PreparedStatement consulta = con.getConnection().prepareStatement("DELETE FROM equipo WHERE id_equipo = ?");
            consulta.setInt(1, id);
            consulta.executeUpdate();
            if (consulta.executeUpdate() == 1) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConexionMYSQL.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

    //Reserva
    @Override
    public List<Reserva> getDatosReserva() {
        List<Reserva> reserva = new ArrayList<>();
        try {
            PreparedStatement consulta = con.getConnection().prepareStatement("SELECT `id_reserva`, `titulacion`, `periodo_academico`,`nivel_academico`,`componente`,`codigo_proyecto`,`tema_practica`,`docente`, `estudiante`,`ciclo`, `fecha`, `hora`,`laboratorio_id_laboratorio`,`usuario_id_usuario`  FROM `reserva`");
            ResultSet resultado = consulta.executeQuery();
            while (resultado.next()) {
                reserva.add(new Reserva(resultado.getInt("id_reserva"), resultado.getString("titulacion"), resultado.getString("periodo_academico"), resultado.getString("nivel_academico"), resultado.getString("componente"), resultado.getString("codigo_proyecto"), resultado.getString("tema_practica"), resultado.getString("docente"), resultado.getString("estudiante"), resultado.getString("ciclo"), resultado.getString("fecha"), resultado.getString("hora"), resultado.getInt("laboratorio_id_laboratorio"), resultado.getInt("usuario_id_usuario")));
            }
        } catch (SQLException ex) {
            try {
                throw new SQLException(ex);
            } catch (SQLException ex1) {
                Logger.getLogger(ConexionMYSQL.class.getName()).log(Level.SEVERE, null, ex1);
            }

        }
        return reserva;
    }

    @Override
    public Reserva getDatoReserva(int id_reserva) {
        Reserva reservaRegistrado = new Reserva();
        try {
            PreparedStatement consulta = con.getConnection().prepareStatement("SELECT `id_reserva`, `titulacion`, `periodo_academico`,`nivel_academico`,`componente`,`codigo_proyecto`,`tema_practica`,`docente`, `estudiante`,`ciclo`, `fecha`, `hora`,`laboratorio_id_laboratorio`,`usuario_id_usuario`  FROM `reserva` WHERE id_reserva = " + id_reserva);
            ResultSet resultado = consulta.executeQuery();
            while (resultado.next()) {
                reservaRegistrado = new Reserva(resultado.getInt("id_reserva"), resultado.getString("titulacion"), resultado.getString("periodo_academico"), resultado.getString("nivel_academico"), resultado.getString("componente"), resultado.getString("codigo_proyecto"), resultado.getString("tema_practica"), resultado.getString("docente"), resultado.getString("estudiante"), resultado.getString("ciclo"), resultado.getString("fecha"), resultado.getString("hora"), resultado.getInt("laboratorio_id_laboratorio"), resultado.getInt("usuario_id_usuario"));
            }
        } catch (SQLException ex) {
            try {
                throw new SQLException(ex);
            } catch (SQLException ex1) {
                Logger.getLogger(ConexionMYSQL.class.getName()).log(Level.SEVERE, null, ex1);
            }
        }
        return reservaRegistrado;
    }

    @Override
    public Reserva insertDatosReserva(Reserva reserva) {
        try {
            PreparedStatement consulta = con.getConnection().prepareStatement("INSERT INTO reserva(`id_reserva`, `titulacion`, `periodo_academico`,`nivel_academico`,`componente`,`codigo_proyecto`,`tema_practica`,`docente`, `estudiante`,`ciclo`, `fecha`, `hora`,`laboratorio_id_laboratorio`,`usuario_id_usuario`)"
                    + "VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
            consulta.setInt(1, reserva.getId_reserva());
            consulta.setString(2, reserva.getTitulacion());
            consulta.setString(3, reserva.getPeriodo_academico());
            consulta.setString(4, reserva.getNivel_academico());
            consulta.setString(5, reserva.getComponente());
            consulta.setString(6, reserva.getCodigo_proyecto());
            consulta.setString(7, reserva.getTema_practica());
            consulta.setString(8, reserva.getDocente());
            consulta.setString(9, reserva.getEstudiante());
            consulta.setString(10, reserva.getCiclo());
            consulta.setString(11, reserva.getFecha());
            consulta.setString(12, reserva.getHora());
            consulta.setInt(13, reserva.getLaboratorio_id_laboratorio());
            consulta.setInt(14, reserva.getUsuario_id_usuario());
            consulta.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ConexionMYSQL.class.getName()).log(Level.SEVERE, null, ex);

        }
        return reserva;
    }

    @Override
    public Reserva updateDatosReserva(Reserva reserva) {
        try {
            PreparedStatement consulta = con.getConnection().prepareStatement("UPDATE reserva SET titulacion=?, periodo_academico=?, nivel_academico=?, componente=?, codigo_proyecto=?, tema_practica=?, docente=?, estudiante=?, ciclo=?, fecha=?, hora=?, laboratorio_id_laboratorio=?, usuario_id_usuario=? WHERE id_reserva = ?");
            consulta.setString(1, reserva.getTitulacion());
            consulta.setString(2, reserva.getPeriodo_academico());
            consulta.setString(3, reserva.getNivel_academico());
            consulta.setString(4, reserva.getComponente());
            consulta.setString(5, reserva.getCodigo_proyecto());
            consulta.setString(6, reserva.getTema_practica());
            consulta.setString(7, reserva.getDocente());
            consulta.setString(8, reserva.getEstudiante());
            consulta.setString(9, reserva.getCiclo());
            consulta.setString(10, reserva.getFecha());
            consulta.setString(11, reserva.getHora());
            consulta.setInt(12, reserva.getLaboratorio_id_laboratorio());
            consulta.setInt(13, reserva.getUsuario_id_usuario());
            consulta.setInt(14, reserva.getId_reserva());
            consulta.executeUpdate();
        } catch (SQLException ex) {
            Logger.getLogger(ConexionMYSQL.class.getName()).log(Level.SEVERE, null, ex);
        }

        return reserva;

    }

    @Override
    public boolean delateDatosReserva(int id) {
        try {
            PreparedStatement consulta = con.getConnection().prepareStatement("DELETE FROM reserva WHERE id_reserva = ?");
            consulta.setInt(1, id);
            consulta.executeUpdate();
            if (consulta.executeUpdate() == 1) {
                return true;
            }
        } catch (SQLException ex) {
            Logger.getLogger(ConexionMYSQL.class.getName()).log(Level.SEVERE, null, ex);
        }

        return false;
    }

}
