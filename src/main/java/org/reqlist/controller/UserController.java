package org.reqlist.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import javax.servlet.ServletResponse;
import org.apache.commons.io.IOUtils;
import org.reqlist.entity.Profile;
import org.reqlist.entity.User;
import org.reqlist.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Controller for operations on a {@link User} REST Resource
 * @author Vinicius Pires <vinicius.costa.pires at gmail.com>
 */
@RestController
@RequestMapping("user")
public class UserController {
    
    @Autowired UserService service;
    
    @RequestMapping(method = RequestMethod.GET)
    public List<Profile> list(@RequestParam("project") Long id) {
        return service.findByProject(id);
    }
    
    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public User get(@PathVariable("id") Long id) {
        return service.get(id);
    }
    
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<User> save(@RequestBody User user) {
        User newUser = service.save(user);
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }
    
    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public ResponseEntity<User> update(@PathVariable("id") Long id, @RequestBody User user) {
        
        user.setId(id);
        
        User updatedUser = service.update(user);
        
        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }
    
    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public ResponseEntity delete(@PathVariable("id") Long id) {
        service.delete(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT); 
    }
    
}