package com.dnchamba.arqapp.rest.dao;

import com.dnchamba.arqapp.dominio.Conexion;
import com.dnchamba.arqapp.rest.model.Usuario;
import java.util.List;
import java.util.Optional;

/**
 *
 * @author Dayana
 */
public class UsuarioDAO {

    private static Conexion usuarios;
//    private static List<Usuario> usuarios1= DatabaseClass.getUsuarios();

    public UsuarioDAO(Conexion usuarios) {
        this.usuarios = usuarios;
    }

    public List<Usuario> getUsuarios() {
        return usuarios.getDatosUsuario();
    }

    public Usuario getUsuario(String usuario, String clave) {
        return usuarios.getDatoUsuario(usuario, clave);
    }
    
    public Usuario obtenerEncargadoDatosLab(int id) {
        return usuarios.obtenerEncargadoDatosLab(id);
    }

    public Usuario insertarUsuario(Usuario usuario) {
        usuarios.insertDatosUsuario(usuario);
        return usuario;
    }

    public Usuario updateUsuario(Usuario usuario) {

        usuarios.updateDatosUsuario(usuario);

        return usuario;
    }

    public boolean deleteUsuario(int id) {

        if (usuarios.delateDatosUsuario(id)) {
            return true;
        } else {
            return false;
        }

    }
    
    

//     public Usuario getUsuario(int id){
//        Optional<Usuario> optProduct= usuarios1.stream().filter(p -> id == p.getId_usuario()).findFirst();
//              
//         
//        return optProduct.isPresent() ? optProduct.get() : null;
//        
//    }
//    public Usuario addUsuario(Usuario usuario) {
//            usuario.setId_usuario(getMax());
//            usuarios1.add(usuario);
//            return usuario;
//    }
//    
//    private int getMax(){
//        int size=usuarios1.size();
//        if (size > 0) {
//            return usuarios1.get(size-1).getId_usuario()+1;          
//        }else{
//            return 1;
//        }
//    }
//    
//    public Usuario updateUsuario(Usuario usuario){
//        int pos = getPos(usuario.getId_usuario());
//        
//        try {
//            usuarios1.set(pos, usuario);
//        } catch (Exception e) {
//            return null;
//        }
//        return usuario;
//    }
//    
//    private int getPos(int id){
//        for (int i = 0; i< usuarios1.size(); i++){
//            if (usuarios1.get(i).getId_usuario()==id) {
//                return i;
//                
//            }
//        }
//        return -1;
//    }
//    
//    public boolean deleteUsuario(int id){
//        int pos = getPos(id);
//        if(pos !=-1){
//            usuarios1.remove(pos);
//            return true;
//        }
//        return false;
//    }
}
