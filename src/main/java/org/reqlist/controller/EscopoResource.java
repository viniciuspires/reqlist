/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.reqlist.controller;

/**
 *
 * @author Vinicius
 */
//@Path("escopo")
//@Produces("application/json; charset=utf-8")
public class EscopoResource {
    /*Projeto projeto = null;
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
    
    // Subresources
    @Path("{id}/requisito")
    public RequisitoResource getRequisitoResource(@PathParam("id") Integer id) {
        RequisitoResource requisitoResource = new RequisitoResource();
        requisitoResource.setEscopo( new Escopo(id) );
        return requisitoResource;
    }
    @Path("{id}/tarefa")
    public TarefaResource getTarefaResource(@PathParam("id") Integer id) {
        TarefaResource tarefaResource = new TarefaResource();
        tarefaResource.setEscopo( new Escopo(id) );
        return tarefaResource;
    }
    @Path("{id}/alocacao")
    public AlocacaoResource getAlocacaoResource(@PathParam("id") Integer id) {
        AlocacaoResource alocacaoResource = new AlocacaoResource();
        alocacaoResource.setEscopo( new Escopo(id) );
        return alocacaoResource;
    }
    @Path("{id}/entrega")
    public EntregaResource getEntregaResource(@PathParam("id") Integer id) {
        EntregaResource entregaResource = new EntregaResource();
        entregaResource.setEscopo( new Escopo(id) );
        return entregaResource;
    }*/
}