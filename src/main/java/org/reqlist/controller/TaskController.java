package org.reqlist.controller;

import java.util.List;
import org.reqlist.entity.Task;
import org.reqlist.service.TaskService;
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
 * Controller for operations on a {@link Task} REST Resource
 * @author Vinicius Pires <vinicius.costa.pires at gmail.com>
 */
@RestController
@RequestMapping("task")
public class TaskController {
    
    @Autowired TaskService service;
    
    @RequestMapping(method = RequestMethod.GET)
    public List<Task> list(@RequestParam("scope") Long id){
        return service.findByScope(id);
    }
    
    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public Task get(@PathVariable("id") Long id) {
        return service.get(id);
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<Task> save(@RequestBody Task task) {
        Task newTask = service.save(task);
        return new ResponseEntity<>(newTask, HttpStatus.CREATED);
    }
    
    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public ResponseEntity<Task> update(@PathVariable("id") Long id, @RequestBody Task task) {
        
        task.setId(id);
        
        Task updatedTask = service.update(task);
        
        return new ResponseEntity<>(updatedTask, HttpStatus.OK);
    }
    
    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public ResponseEntity delete(@PathVariable("id") Long id) {
        service.delete(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT); 
    }
    
}