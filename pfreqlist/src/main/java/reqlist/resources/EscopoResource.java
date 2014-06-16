/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package reqlist.resources;

import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import reqlist.dao.EscopoDAO;
import reqlist.entity.Escopo;

/**
 *
 * @author Vinicius
 */
@Path("escopo")
class EscopoResource {
    EscopoDAO dao;
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Escopo> get() {
        
        return null;
    }
    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Escopo getById(@PathParam("id") Long id) {
        
        return null;
    }
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void post() {
        
    }
    @PUT
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public void put(@PathParam("id") Long id) {
        
    }
    @DELETE
    @Path("{id}")
    public void delete(@PathParam("id") Long id) {
        
    }
    
    
}
