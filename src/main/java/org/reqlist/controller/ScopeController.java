package org.reqlist.controller;

import java.util.List;
import org.reqlist.entity.Scope;
import org.reqlist.service.ScopeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller for operations on a {@link Scope} REST Resource
 * @author Vinicius Pires <vinicius.costa.pires at gmail.com>
 */
@RestController
@RequestMapping("scope")
public class ScopeController {
    
    @Autowired
    private ScopeService service;
    
    @RequestMapping(method = RequestMethod.GET)
    public List<Scope> list(@RequestParam("project") Long id){
        return service.findByProject(id);
    }
    
    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public Scope get(@PathVariable("id") Long id) {
        return service.get(id);
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Scope> save(@RequestBody Scope scope) {
        Scope newScope = service.save(scope);
        return new ResponseEntity<>(newScope, HttpStatus.CREATED);
    }
    
    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public ResponseEntity<Scope> update(@PathVariable("id") Long id, @RequestBody Scope scope) {
        
        scope.setId(id);
        
        Scope updatedScope = service.update(scope);
        
        return new ResponseEntity<>(updatedScope, HttpStatus.OK);
    }
    
    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public ResponseEntity delete(@PathVariable("id") Long id) {
        service.delete(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT); 
    }
    
    /*
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
    */
}