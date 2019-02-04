package com.dnchamba.arqapp.rest.ws;

import com.dnchamba.arqapp.adapter.ConexionMYSQL;
import com.dnchamba.arqapp.dominio.Conexion;
import com.dnchamba.arqapp.rest.dao.LaboratorioDAO;
import com.dnchamba.arqapp.rest.model.Laboratorio;
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
@Path("laboratorios")
public class LaboratorioService {
    private static Conexion usuario = new ConexionMYSQL();
    private static LaboratorioDAO laboratorioDAO = new LaboratorioDAO(usuario);

    public LaboratorioService() {
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Laboratorio> getAllLaboratorio(){
        return laboratorioDAO.getDatosLaboratorio();
    }
    
    @GET
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getLaboratorio(@PathParam("id") int id){
        Laboratorio output = laboratorioDAO.getLaboratorio(id);
        
        if (output != null) {
            return Response.ok(output).build();
            
        }else{
            return Response.status(Response.Status.NOT_FOUND).build();
        }
    }
    
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response addLaboratorio(Laboratorio laboratorio, @Context UriInfo uriInfo){
        Laboratorio newLaboratorio = laboratorioDAO.insertarLaboratorio(laboratorio);
        
        UriBuilder uriBuilder = uriInfo.getAbsolutePathBuilder();
        
        URI newUri = uriBuilder.path(String.valueOf(newLaboratorio.getId_laboratorio())).build();
        
        
        
        return Response.created(newUri).entity(newLaboratorio).build();
    }
    @PUT
    @Path("/{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Laboratorio updateLaboratorio(@PathParam("id")int id, Laboratorio laboratorio){
        laboratorio.setId_laboratorio(id);
        return laboratorioDAO.updateLaboratorio(laboratorio);
    }
    
    @DELETE
    @Path("/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response remove(@PathParam("id") int id){
        if (laboratorioDAO.deleteLaboratorio(id)){
            return Response.noContent().build();
        }
        return Response.status(Response.Status.NOT_FOUND).build();
    }
}
