/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package reqlist.resources;

import java.util.ArrayList;
import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import reqlist.dao.ProjetoDAO;
import reqlist.entity.Projeto;
import reqlist.entity.view.AndamentoProjeto;
import reqlist.model.AndamentoEscopo;

/**
 *
 * @author Iran
 */
@Path("projeto")
@Produces("application/json; charset=utf-8")
public class ProjetoResource {
    ProjetoDAO dao = new ProjetoDAO();
    
    @GET
    public List getProjetos(){
        return dao.findAll();
    }
    
    @GET
    @Path("{id}")
    public Projeto getProjeto(@PathParam("id") Integer id) {
        Projeto projeto = dao.getById(id);
        if ( projeto == null ) {
            throw new NotFoundException();
        }
        return projeto;
    }
    
    @GET
    @Path("{id}/andamento")
    public List<AndamentoProjeto> getAndamentoProjeto(@PathParam("id") Integer id) {
        
        return dao.getAndamento(id);
    }
    
    @Path("{id}/escopo")
    public EscopoResource getEscopoResource(@PathParam("id") Integer id) {
        EscopoResource escopoResource = new EscopoResource();
        escopoResource.setProjeto( new Projeto(id) );
        return escopoResource;
    }
}