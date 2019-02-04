/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dnchamba.arqapp.rest.ws;

import com.dnchamba.arqapp.adapter.ConexionMYSQL;
import com.dnchamba.arqapp.dominio.Conexion;
import com.dnchamba.arqapp.rest.dao.SeccionEnsayoDAO;
import com.dnchamba.arqapp.rest.model.SeccionEnsayo;
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
 * @author Jhuliana
 */
@Path("seccion")
public class SeccionEnsayoService {
    private static Conexion usuario = new ConexionMYSQL();
    private static SeccionEnsayoDAO seccionEnsayoDAO = new SeccionEnsayoDAO(usuario);
    
    

    public SeccionEnsayoService() {
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<SeccionEnsayo> getAllSeccionEnsayos(){
        return seccionEnsayoDAO.getDatosSeccionEnsayo();
    }     
    
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getSeccionEnsayo(@PathParam("id") int id){
        SeccionEnsayo output = seccionEnsayoDAO.getSeccionEnsayo(id);
        
        if (output != null) {
            return Response.ok(output).build();
            
        }else{
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addEnsayo(SeccionEnsayo seccionEnsayo, @Context UriInfo uriInfo){
        SeccionEnsayo newSeccionEnsayo = seccionEnsayoDAO.insertarSeccionEnsayo(seccionEnsayo);
        
        UriBuilder uriBuilder = uriInfo.getAbsolutePathBuilder();
        
        URI newUri = uriBuilder.path(String.valueOf(newSeccionEnsayo.getId_seccion_ensayo())).build();
           
        return Response.created(newUri).entity(newSeccionEnsayo).build();
    }
    
    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public SeccionEnsayo updateEnsayo(@PathParam("id")int id, SeccionEnsayo seccionEnsayo){
        seccionEnsayo.setId_seccion_ensayo(id);
        return seccionEnsayoDAO.updateEnsayo(seccionEnsayo);
    }
    
    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response remove(@PathParam("id") int id){
        if (seccionEnsayoDAO.deleteSeccionEnsayo(id)){
            
            return Response.noContent().build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }    
}
