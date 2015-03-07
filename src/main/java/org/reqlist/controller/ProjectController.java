package org.reqlist.controller;

import java.util.List;
import org.reqlist.entity.Project;
import org.reqlist.service.ProjectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller for operations on a {@link Project} REST Resource
 * @author Vinicius Pires <vinicius.costa.pires at gmail.com>
 */
@RestController
@RequestMapping("project")
public class ProjectController {
    
    @Autowired
    private ProjectService service;
    
    @RequestMapping(method = RequestMethod.GET)
    public List<Project> list(){
        return service.findAll();
    }
    
    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public Project get(@PathVariable("id") Long id) {
        return service.getById(id);
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Project> save(@RequestBody Project project) {
        Project newProject = service.save(project);
        return new ResponseEntity<>(newProject, HttpStatus.CREATED);
    }
    
    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public ResponseEntity<Project> update(@PathVariable("id") Long id, @RequestBody Project project) {
        
        project.setId(id);
        
        Project updatedProject = service.update(project);
        
        return new ResponseEntity<>(updatedProject, HttpStatus.OK);
    }
    
    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public ResponseEntity delete(@PathVariable("id") Long id) {
        service.delete(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT); 
    }
    
    /*@RequestMapping(value="{id}/andamento", method = RequestMethod.GET)
    public Andamento getAndamentoProjeto(@PathVariable("id") Integer id) {
        return new Andamento( service.getProjectProgress(id) );
    }
    
    @RequestMapping(value="comparacao", method = RequestMethod.GET)
    public PerformanceComparacao getComparacaoProjetos() {
        return new PerformanceComparacao( service.getProjectComparison() );
    }*/
    
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