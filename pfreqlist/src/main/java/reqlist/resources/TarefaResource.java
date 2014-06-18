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
import reqlist.dao.TarefaDAO;
import reqlist.entity.Escopo;
import reqlist.entity.Tarefa;

/**
 *
 * @author Vinicius
 */
@Path("tarefa")
@Produces("application/json; charset=utf-8")
public class TarefaResource {
    private Escopo escopo;
    TarefaDAO dao = new TarefaDAO();
    
    @GET
    public List<Tarefa> get() {
        List<Tarefa> tarefas;
        if ( this.escopo != null ) {
            tarefas = dao.findByEscopo(escopo);
        } else {
            tarefas = dao.findAll();
        }
        return tarefas;
    }
    @GET
    @Path("{id}")
    public Tarefa getById(@PathParam("id") Integer id) {
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
