package com.dnchamba.arqapp.adapter;

import com.dnchamba.arqapp.dominio.Conexion;
import com.dnchamba.arqapp.rest.model.Ensayo;
import com.dnchamba.arqapp.rest.model.Laboratorio;
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
            PreparedStatement consulta = con.getConnection().prepareStatement("SELECT Id_usuario, cedula, nombres, usuario, contrasenia, tipo FROM usuario");
            ResultSet resultado = consulta.executeQuery();
            while (resultado.next()) {
                usuario.add(new Usuario(resultado.getInt("Id_usuario"), resultado.getString("cedula"), resultado.getString("nombres"), resultado.getString("usuario"), resultado.getString("contrasenia"), resultado.getInt("tipo")));
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
            PreparedStatement consulta = con.getConnection().prepareStatement("SELECT usuario, contrasenia, tipo FROM usuario WHERE usuario = '" + usuario + "' AND contrasenia = '" + contrasenia + "'");
            ResultSet resultado = consulta.executeQuery();
            while (resultado.next()) {
                usuarioRegistrado = new Usuario(resultado.getString("usuario"), resultado.getString("contrasenia"), resultado.getInt("tipo"));
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
            PreparedStatement consulta = con.getConnection().prepareStatement("INSERT INTO usuario(cedula, nombres, usuario, contrasenia, tipo)"
                    + "VALUES (?,?,?,?,?)");
            consulta.setString(1, usuario.getCedula());
            consulta.setString(2, usuario.getNombres());
            consulta.setString(3, usuario.getUsuario());
            consulta.setString(4, usuario.getContrasenia());
            consulta.setInt(5, usuario.getTipo());
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
            PreparedStatement consulta = con.getConnection().prepareStatement("SELECT id_laboratorio, nombre, nombre, descripcion, usuario_id_usuario FROM laboratorio");
            ResultSet resultado = consulta.executeQuery();
            while (resultado.next()) {
                laboratorio.add(new Laboratorio(resultado.getInt("id_laboratorio"), resultado.getString("nombre"), resultado.getString("descripcion"), resultado.getInt("usuario_id_usuario")));
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
            PreparedStatement consulta = con.getConnection().prepareStatement("SELECT nombre, descripcion, usuario_id_usuario FROM laboratorio WHERE id_laboratorio = " + id_laboratorio);
            ResultSet resultado = consulta.executeQuery();
            while (resultado.next()) {
                laboratorioRegistrado = new Laboratorio(resultado.getString("nombre"), resultado.getString("descripcion"), resultado.getInt("usuario_id_usuario"));
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
            PreparedStatement consulta = con.getConnection().prepareStatement("SELECT us.nombres FROM usuario us WHERE us.id_usuario = " + id_usuario_id_usuario);
            ResultSet resultado = consulta.executeQuery();
            while (resultado.next()) {
                usuarioRegistrado = new Usuario(resultado.getString("nombres"));

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

}
