package org.reqlist.service;

import java.util.Date;
import java.util.List;
import org.reqlist.arch.ValidatorProvider;
import org.reqlist.arch.exception.ResourceNotFoundException;
import org.reqlist.entity.Task;
import org.reqlist.repository.TaskRepository;
import static org.reqlist.util.AssertUtils.isNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Vinicius Pires <vinicius.costa.pires at gmail.com>
 */
@Service
public class TaskService {

    @Autowired TaskRepository repository;
    @Autowired ValidatorProvider vp;

    public Task get(Long id) {
        Task task = repository.findOne(id);
        
        if (isNull(task)) {
            throw new ResourceNotFoundException();
        }
        
        return task;
    }

    public List<Task> findByScope(Long id) {
        return repository.findByScope(id);
    }

    public Task save(Task task) {
        task.setRegisterDate(new Date());
        task.setDone(false);
        
        vp.basicValidate(task);
        
        return repository.save(task);
    }

    public Task update(Task task) {
        vp.basicValidate(task);
        
        return repository.save(task);
    }

    public void delete(Long id) {
        Task task = get(id);
        repository.delete(task);
    }

}
