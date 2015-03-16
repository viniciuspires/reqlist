package org.reqlist.service;

import java.util.Date;
import java.util.List;
import org.reqlist.arch.ValidatorProvider;
import org.reqlist.arch.exception.ResourceNotFoundException;
import org.reqlist.entity.Project;
import org.reqlist.repository.ProjectRepository;
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
public class ProjectService {

    @Autowired ProjectRepository repository;
    @Autowired ValidatorProvider vp;

    public List<Project> findAll() {
        return repository.findAll();
    }

    public Project getById(Long id) {
        Project project = repository.findOne(id);
        
        if ( isNull(project) ) {
            throw new ResourceNotFoundException();
        }
        
        return project;
    }

    public Project save(Project project) {
        project.setRegisterDate(new Date());
        project.setActive(true);
        
        vp.basicValidate(project);
        
        return repository.save(project);
    }

    public Project update(Project project) {
        vp.basicValidate(project);
        
        return repository.save(project);
    }
    
    @Transactional(propagation = Propagation.REQUIRED)
    public void delete(Long id) {
        Project project = getById(id);
        repository.delete(project);
    }
    
    /*public List<ProjectProgress> getProjectProgress(Integer id) {
        return repository.getProjectProgress(id);
    }

    public List<ProjectComparison> getProjectComparison() {
        return repository.getProjectComparison();
    }*/
}
