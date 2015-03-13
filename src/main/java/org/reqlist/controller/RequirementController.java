package org.reqlist.controller;

import java.util.List;
import org.reqlist.entity.Requirement;
import org.reqlist.service.RequirementService;
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
 * Controller for operations on a {@link Requirement} REST Resource
 * @author Vinicius Pires <vinicius.costa.pires at gmail.com>
 */
@RestController
@RequestMapping("requirement")
public class RequirementController {
    
    @Autowired RequirementService service;
    
    @RequestMapping(method = RequestMethod.GET)
    public List<Requirement> list(@RequestParam("scope") Long id){
        return service.findByScope(id);
    }
    
    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public Requirement get(@PathVariable("id") Long id) {
        return service.get(id);
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Requirement> save(@RequestBody Requirement requirement) {
        Requirement newRequirement = service.save(requirement);
        return new ResponseEntity<>(newRequirement, HttpStatus.CREATED);
    }
    
    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public ResponseEntity<Requirement> update(@PathVariable("id") Long id, @RequestBody Requirement requirement) {
        
        requirement.setId(id);
        
        Requirement updatedRequirement = service.update(requirement);
        
        return new ResponseEntity<>(updatedRequirement, HttpStatus.OK);
    }
    
    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public ResponseEntity delete(@PathVariable("id") Long id) {
        service.delete(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT); 
    }
    
}