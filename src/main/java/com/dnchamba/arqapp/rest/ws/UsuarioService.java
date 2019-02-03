package com.dnchamba.arqapp.rest.ws;

import com.dnchamba.arqapp.adapter.ConexionMYSQL;
import com.dnchamba.arqapp.dominio.Conexion;
import com.dnchamba.arqapp.rest.dao.UsuarioDAO;
import com.dnchamba.arqapp.rest.model.Usuario;
import java.net.URI;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import javax.ws.rs.core.UriInfo;
/**
 *
 * @author Dayana
 */
@Path("usuarios")
public class UsuarioService {    
    private static Conexion usuario = new ConexionMYSQL();
    private static UsuarioDAO usuarioDAO = new UsuarioDAO(usuario);
    
    //private static UsuarioDAO usuarioDAO1 = new UsuarioDAO();

    public UsuarioService() {
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Usuario> getAllUsuarios(){
        return usuarioDAO.getUsuarios();
    }     
    
    @GET
    @Path("/{usuario}/{clave}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUsuario(@PathParam("usuario") String usuario, @PathParam("clave") String clave ){
        Usuario output = usuarioDAO.getUsuario(usuario, clave);
        
        if (output != null) {
            return Response.ok(output).build();
            
        }else{
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
    
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getUsuarioEncargado(@PathParam("id") int id){
        Usuario output = usuarioDAO.obtenerEncargadoDatosLab(id);
        
        if (output != null) {
            return Response.ok(output).build();
            
        }else{
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addUsuario(Usuario usuario, @Context UriInfo uriInfo){
        Usuario newUsuario = usuarioDAO.insertarUsuario(usuario);
        
        UriBuilder uriBuilder = uriInfo.getAbsolutePathBuilder();
        
        URI newUri = uriBuilder.path(String.valueOf(newUsuario.getId_usuario())).build();
        
        
        
        return Response.created(newUri).entity(newUsuario).build();
    }
    
    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Usuario updateUsuario(@PathParam("id")int id, Usuario usuario){
        usuario.setId_usuario(id);
        return usuarioDAO.updateUsuario(usuario);
    }
    
    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response remove(@PathParam("id") int id){
        if (usuarioDAO.deleteUsuario(id)){
            return Response.noContent().build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }    
}
