package org.reqlist.service;

import java.util.List;
import org.reqlist.entity.Project;
import org.reqlist.entity.view.ProjectComparison;
import org.reqlist.entity.view.ProjectProgress;
import org.reqlist.repository.ProjectRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Vinicius Pires <vinicius.costa.pires at gmail.com>
 */
@Service
public class ProjectService {
    
    @Autowired
    private ProjectRepository repository;

    public List<Project> findAll() {
        return repository.findAll();
    }

    public Project getById(Integer id) {
        return repository.findOne(id);
    }

    public List<ProjectProgress> getProjectProgress(Integer id) {
        return repository.getProjectProgress(id);
    }

    public List<ProjectComparison> getProjectComparison() {
        return repository.getProjectComparison();
    }
    
}
