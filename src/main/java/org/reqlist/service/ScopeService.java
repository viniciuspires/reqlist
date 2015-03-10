package org.reqlist.service;

import java.util.Date;
import java.util.List;
import org.reqlist.arch.ValidatorProvider;
import org.reqlist.arch.exception.ResourceNotFoundException;
import org.reqlist.entity.Scope;
import org.reqlist.repository.ScopeRepository;
import static org.reqlist.util.AssertUtils.isNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Vinicius Pires <vinicius.costa.pires at gmail.com>
 */
@Service
public class ScopeService {
    
    @Autowired
    private ScopeRepository repository;

    @Autowired
    private ValidatorProvider vp;

    public List<Scope> findByProject(Long id) {
        return repository.findAllByProject(id);
    }

    public Scope get(Long id) {
        Scope scope = repository.findOne(id);
        
        if ( isNull(scope) ) {
            throw new ResourceNotFoundException();
        }
        
        return scope;
    }

    public Scope save(Scope scope) {
        scope.setRegisterDate(new Date());
        scope.setActive(true);
        
        vp.basicValidate(scope);
        
        return repository.save(scope);
    }

    public Scope update(Scope scope) {
        vp.basicValidate(scope);
        
        return repository.save(scope);
    }

    public void delete(Long id) {
        Scope scope = get(id);
        repository.delete(scope);
    }

}
