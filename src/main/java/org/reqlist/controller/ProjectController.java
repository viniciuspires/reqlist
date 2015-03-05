package org.reqlist.controller;

import java.util.List;
import org.reqlist.entity.Project;
import org.reqlist.model.Andamento;
import org.reqlist.model.PerformanceComparacao;
import org.reqlist.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister.NotFoundException;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("project")
public class ProjectController {
    
    @Autowired
    private ProjectService service;
    
    @RequestMapping(method = RequestMethod.GET)
    public List<Project> listProjects(){
        return service.findAll();
    }
    
    //@GET
    //@Path("{id}")
    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public Project getProject(@PathVariable("id") Integer id) throws NotFoundException {
        Project project = service.getById(id);
        if ( project == null ) {
            throw new NotFoundException();
        }
        return project;
    }
    
    //@GET
    //@Path("{id}/andamento")
    @RequestMapping(value="{id}/andamento", method = RequestMethod.GET)
    public Andamento getAndamentoProjeto(@PathVariable("id") Integer id) {
        return new Andamento( service.getProjectProgress(id) );
    }
    
    //@GET
    //@Path("comparacao")
    @RequestMapping(value="comparacao", method = RequestMethod.GET)
    public PerformanceComparacao getComparacaoProjetos() {
        return new PerformanceComparacao( service.getProjectComparison() );
    }
    
    // Subresources
    /*@Path("{id}/escopo")
    public EscopoResource getEscopoResource(@PathParam("id") Integer id) {
        EscopoResource escopoResource = new EscopoResource();
        escopoResource.setProjeto( new Project(id) );
        return escopoResource;
    }
    @Path("{id}/objetivo")
    public ObjetivoResource getObjetivoResource(@PathParam("id") Integer id) {
        ObjetivoResource objetivoResource = new ObjetivoResource();
        objetivoResource.setProjeto( new Project(id) );
        return objetivoResource;
    }*/
}