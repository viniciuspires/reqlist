package org.reqlist.controller;

import java.util.List;
import org.reqlist.dao.ProjetoDAO;
import org.reqlist.entity.Projeto;
import org.reqlist.model.Andamento;
import org.reqlist.model.PerformanceComparacao;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//@Path("projeto")
@RestController
@RequestMapping("projeto")
//@Produces("application/json; charset=utf-8")
public class ProjetoResource {
    ProjetoDAO dao = new ProjetoDAO();
    
    @RequestMapping(method = RequestMethod.GET)
    public List getProjetos(){
        return dao.findAll();
    }
    
    //@GET
    //@Path("{id}")
    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public Projeto getProjeto(@PathVariable("id") Integer id) throws NotFoundException {
        Projeto projeto = dao.getById(id);
        if ( projeto == null ) {
            throw new NotFoundException();
        }
        return projeto;
    }
    
    //@GET
    //@Path("{id}/andamento")
    @RequestMapping(value="{id}/andamento", method = RequestMethod.GET)
    public Andamento getAndamentoProjeto(@PathVariable("id") Integer id) {
        return new Andamento( dao.getAndamento(id) );
    }
    
    //@GET
    //@Path("comparacao")
    @RequestMapping(value="comparacao", method = RequestMethod.GET)
    public PerformanceComparacao getComparacaoProjetos() {
        return new PerformanceComparacao( dao.getComparacao() );
    }
    
    // Subresources
    /*@Path("{id}/escopo")
    public EscopoResource getEscopoResource(@PathParam("id") Integer id) {
        EscopoResource escopoResource = new EscopoResource();
        escopoResource.setProjeto( new Projeto(id) );
        return escopoResource;
    }
    @Path("{id}/objetivo")
    public ObjetivoResource getObjetivoResource(@PathParam("id") Integer id) {
        ObjetivoResource objetivoResource = new ObjetivoResource();
        objetivoResource.setProjeto( new Projeto(id) );
        return objetivoResource;
    }*/
}