/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.reqlist.resources;

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
import org.reqlist.dao.RequisitoDAO;
import org.reqlist.entity.Escopo;
import org.reqlist.entity.Requisito;

/**
 *
 * @author Vinicius
 */
@Path("requisito")
@Produces("application/json; charset=utf-8")
public class RequisitoResource {
    private Escopo escopo;
    RequisitoDAO dao = new RequisitoDAO();
    
    @GET
    public List<Requisito> get() {
        List<Requisito> requisitos;
        if ( this.escopo != null ) {
            requisitos = dao.findByEscopo(escopo);
        } else {
            requisitos = dao.findAll();
        }
        return requisitos;
    }
    @GET
    @Path("{id}")
    public Requisito getById(@PathParam("id") Integer id) {
        return dao.getById(id);
    }
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void post() {
        
    }
    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void put(@PathParam("id") Long id) {
        
    }
    @DELETE
    @Path("{id}")
    public void delete(@PathParam("id") Long id) {
        
    }

    public void setEscopo(Escopo escopo) {
        this.escopo = escopo;
    }
}
