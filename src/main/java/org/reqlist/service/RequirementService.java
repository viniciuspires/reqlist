package org.reqlist.service;

import java.util.Date;
import java.util.List;
import org.reqlist.arch.UserSession;
import org.reqlist.arch.ValidatorProvider;
import org.reqlist.arch.exception.ResourceNotFoundException;
import org.reqlist.entity.Requirement;
import org.reqlist.repository.RequirementRepository;
import static org.reqlist.util.AssertUtils.isNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Vinicius Pires <vinicius.costa.pires at gmail.com>
 */
@Service
public class RequirementService {

    @Autowired RequirementRepository repository;
    @Autowired UserSession session;
    @Autowired ValidatorProvider vp;

    public Requirement get(Long id) {
        Requirement requirement = repository.findOne(id);
        
        if (isNull(requirement)) {
            throw new ResourceNotFoundException();
        }
        
        return requirement;
    }

    public List<Requirement> findByScope(Long id) {
        return repository.findByScope(id);
    }

    public Requirement save(Requirement requirement) {
        requirement.setRegisterDate(new Date());
        requirement.setUser(session.getLoggedInUser());
        requirement.setActive(true);
        
        vp.basicValidate(requirement);
        
        return repository.save(requirement);
    }

    public Requirement update(Requirement requirement) {
        vp.basicValidate(requirement);
        
        return repository.save(requirement);
    }

    public void delete(Long id) {
        Requirement requirement = get(id);
        repository.delete(requirement);
    }

}
