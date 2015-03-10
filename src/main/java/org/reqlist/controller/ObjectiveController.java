package org.reqlist.controller;

import java.util.List;
import org.reqlist.entity.Objective;
import org.reqlist.service.ObjectiveService;
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
 * Controller for operations on a {@link Objective} REST Resource
 * @author Vinicius Pires <vinicius.costa.pires at gmail.com>
 */
@RestController
@RequestMapping("objective")
public class ObjectiveController {
    
    @Autowired
    private ObjectiveService service;
    
    @RequestMapping(method = RequestMethod.GET)
    public List<Objective> list(@RequestParam("project") Long id){
        return service.findByProject(id);
    }
    
    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public Objective get(@PathVariable("id") Long id) {
        return service.get(id);
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Objective> save(@RequestBody Objective objective) {
        Objective newObjective = service.save(objective);
        return new ResponseEntity<>(newObjective, HttpStatus.CREATED);
    }
    
    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public ResponseEntity<Objective> update(@PathVariable("id") Long id, @RequestBody Objective objective) {
        
        objective.setId(id);
        
        Objective updatedObjective = service.update(objective);
        
        return new ResponseEntity<>(updatedObjective, HttpStatus.OK);
    }
    
    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public ResponseEntity delete(@PathVariable("id") Long id) {
        service.delete(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT); 
    }
    
}