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
import org.reqlist.dao.AlocacaoDAO;
import org.reqlist.entity.Alocacao;
import org.reqlist.entity.Escopo;

/**
 *
 * @author Vinicius
 */
@Path("alocacao")
@Produces("application/json; charset=utf-8")
public class AlocacaoResource {
    private Escopo escopo;
    AlocacaoDAO dao = new AlocacaoDAO();
    
    @GET
    public List<Alocacao> get() {
        List<Alocacao> alocacoes;
        if ( this.escopo != null ) {
            alocacoes = dao.findByEscopo(escopo);
        } else {
            alocacoes = dao.findAll();
        }
        return alocacoes;
    }
    @GET
    @Path("{id}")
    public Alocacao getById(@PathParam("id") Integer id) {
        return dao.getById(id);
    }
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void post(Alocacao alocacao) {
        dao.save(alocacao);
    }
    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void put(@PathParam("id") Long id, Alocacao alocacao) throws Exception {
        dao.update(alocacao);
    }
    @DELETE
    @Path("{id}")
    public void delete(@PathParam("id") Integer id) {
        dao.delete(new Alocacao(id));
    }

    public void setEscopo(Escopo escopo) {
        this.escopo = escopo;
    }
}
