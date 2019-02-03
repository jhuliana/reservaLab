/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dnchamba.arqapp.rest.ws;

import com.dnchamba.arqapp.adapter.ConexionMYSQL;
import com.dnchamba.arqapp.dominio.Conexion;
import com.dnchamba.arqapp.rest.dao.EnsayoDAO;
import com.dnchamba.arqapp.rest.model.Ensayo;
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
@Path("ensayos")
public class EnsayoService {
    private static Conexion usuario = new ConexionMYSQL();
    private static EnsayoDAO ensayoDAO = new EnsayoDAO(usuario);
    
    

    public EnsayoService() {
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Ensayo> getAllEnsayos(){
        return ensayoDAO.getDatosEnsayo();
    }     
    
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getEnsayo(@PathParam("id") int id){
        Ensayo output = ensayoDAO.getEnsayo(id);
        
        if (output != null) {
            return Response.ok(output).build();
            
        }else{
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addEnsayo(Ensayo ensayo, @Context UriInfo uriInfo){
        Ensayo newEnsayo = ensayoDAO.insertarEnsayo(ensayo);
        
        UriBuilder uriBuilder = uriInfo.getAbsolutePathBuilder();
        
        URI newUri = uriBuilder.path(String.valueOf(newEnsayo.getId_ensayos())).build();
           
        return Response.created(newUri).entity(newEnsayo).build();
    }
    
    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Ensayo updateEnsayo(@PathParam("id")int id, Ensayo ensayo){
        ensayo.setId_ensayos(id);
        return ensayoDAO.updateEnsayo(ensayo);
    }
    
    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response remove(@PathParam("id") int id){
        if (ensayoDAO.deleteEnsayo(id)){
            
            return Response.noContent().build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }    
}
