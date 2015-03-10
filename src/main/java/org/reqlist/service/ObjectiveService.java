package org.reqlist.service;

import java.util.Date;
import java.util.List;
import org.reqlist.arch.UserSession;
import org.reqlist.arch.ValidatorProvider;
import org.reqlist.arch.exception.ResourceNotFoundException;
import org.reqlist.entity.Objective;
import org.reqlist.repository.ObjectiveRepository;
import static org.reqlist.util.AssertUtils.isNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 *
 * @author Vinicius Pires <vinicius.costa.pires at gmail.com>
 */
@Service
public class ObjectiveService {
    
    @Autowired
    private UserSession session;
    
    @Autowired
    private ObjectiveRepository repository;
    
    @Autowired
    private ValidatorProvider vp;

    public List<Objective> findByProject(Long id) {
        return repository.findAllByProject(id);
    }

    public Objective get(Long id) {
        Objective objective = repository.findOne(id);
        
        if ( isNull(objective) ) {
            throw new ResourceNotFoundException();
        }
        
        return objective;
    }

    public Objective save(Objective objective) {
        objective.setRegisterDate(new Date());
        objective.setUser( session.getLoggedInUser() );
        
        vp.basicValidate(objective);
        
        return repository.save(objective);
    }

    public Objective update(Objective objective) {
        vp.basicValidate(objective);
        
        return repository.save(objective);
    }

    @Transactional(propagation = Propagation.REQUIRED)
    public void delete(Long id) {
        Objective objective = get(id);
        
        repository.delete(objective);
    }

}
