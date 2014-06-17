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
import reqlist.entity.Projeto;
import reqlist.model.Burndown;

/**
 *
 * @author Vinicius
 */
@Path("escopo")
@Produces("application/json; charset=utf-8")
public class EscopoResource {
    Projeto projeto = null;
    EscopoDAO dao = new EscopoDAO();
    
    @GET
    public List<Escopo> get() {
        List<Escopo> escopos;
        if ( projeto != null ) {
            escopos = dao.findByProjeto(projeto);
        } else {
            escopos = dao.findAll();
        }
        return escopos;
    }
    @GET
    @Path("{id}")
    public Escopo getById(@PathParam("id") Integer id) {
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
    
    @GET
    @Path("{id}/burndown")
    public Burndown getBurndownPlanejamento(@PathParam("id") Integer id) {
        Burndown burndown = new Burndown(
            dao.getBurndownPlanejamento(id),
            dao.getBurndownRealizacao(id)
        );
        
        return burndown;
    }

    public void setProjeto(Projeto projeto) {
        this.projeto = projeto;
    }
}