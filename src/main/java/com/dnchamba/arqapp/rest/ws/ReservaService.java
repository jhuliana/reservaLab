/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.dnchamba.arqapp.rest.ws;

import com.dnchamba.arqapp.adapter.ConexionMYSQL;
import com.dnchamba.arqapp.dominio.Conexion;
import com.dnchamba.arqapp.rest.dao.ReservaDAO;
import com.dnchamba.arqapp.rest.model.Reserva;
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
public class ReservaService {
    private static Conexion usuario = new ConexionMYSQL();
    private static ReservaDAO reservaDAO = new ReservaDAO(usuario);


    

    public ReservaService() {
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Reserva> getAllReserva(){
        return reservaDAO.getDatosReserva();
    }     
    
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getReserva(@PathParam("id") int id){
        Reserva output = reservaDAO.getReserva(id);
        
        if (output != null) {
            return Response.ok(output).build();
            
        }else{
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addEquipo(Reserva reserva, @Context UriInfo uriInfo){
        Reserva newReserva = reservaDAO.insertarReserva(reserva);
        
        UriBuilder uriBuilder = uriInfo.getAbsolutePathBuilder();
        
        URI newUri = uriBuilder.path(String.valueOf(newReserva.getId_reserva())).build();
           
        return Response.created(newUri).entity(newReserva).build();
    }
    
    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Reserva updateReserva(@PathParam("id")int id, Reserva reserva){
        reserva.setId_reserva(id);
        return reservaDAO.updateReserva(reserva);
    }
    
    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response remove(@PathParam("id") int id){
        if (reservaDAO.deleteReserva(id)){
            
            return Response.noContent().build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }    
}
