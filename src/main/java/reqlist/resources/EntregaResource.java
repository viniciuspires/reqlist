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
import reqlist.dao.ObjetivoDAO;
import reqlist.entity.Escopo;
import reqlist.entity.Objetivo;
import reqlist.entity.Projeto;

/**
 *
 * @author Vinicius
 */
@Path("entrega")
@Produces("application/json; charset=utf-8")
public class EntregaResource {
    private Projeto projeto;
    ObjetivoDAO dao = new ObjetivoDAO();
    
    @GET
    public List<Objetivo> get() {
        List<Objetivo> objetivos;
        if ( this.projeto != null ) {
            objetivos = dao.findByProjeto(projeto);
        } else {
            objetivos = dao.findAll();
        }
        return objetivos;
    }
    @GET
    @Path("{id}")
    public Objetivo getById(@PathParam("id") Integer id) {
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

    public void setProjeto(Projeto projeto) {
        this.projeto = projeto;
    }

    void setEscopo(Escopo escopo) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
