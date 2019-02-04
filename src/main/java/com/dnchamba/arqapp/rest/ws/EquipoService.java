/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dnchamba.arqapp.rest.ws;

import com.dnchamba.arqapp.adapter.ConexionMYSQL;
import com.dnchamba.arqapp.dominio.Conexion;
import com.dnchamba.arqapp.rest.dao.EquipoDAO;
import com.dnchamba.arqapp.rest.model.Equipo;
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
@Path("equipo")
public class EquipoService {

    private static Conexion usuario = new ConexionMYSQL();
    private static EquipoDAO equipoDAO = new EquipoDAO(usuario);


    

    public EquipoService() {
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Equipo> getAllEquipos(){
        return equipoDAO.getDatosEquipo();
    }     
    
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getEquipo(@PathParam("id") int id){
        Equipo output = equipoDAO.getEquipo(id);
        
        if (output != null) {
            return Response.ok(output).build();
            
        }else{
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addEquipo(Equipo equipo, @Context UriInfo uriInfo){
        Equipo newEquipo = equipoDAO.insertarEquipo(equipo);
        
        UriBuilder uriBuilder = uriInfo.getAbsolutePathBuilder();
        
        URI newUri = uriBuilder.path(String.valueOf(newEquipo.getId_equipo())).build();
           
        return Response.created(newUri).entity(newEquipo).build();
    }
    
    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Equipo updateEquipo(@PathParam("id")int id, Equipo equipo){
        equipo.setId_equipo(id);
        return equipoDAO.updateEquipo(equipo);
    }
    
    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response remove(@PathParam("id") int id){
        if (equipoDAO.deleteEquipo(id)){
            
            return Response.noContent().build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }    
}
