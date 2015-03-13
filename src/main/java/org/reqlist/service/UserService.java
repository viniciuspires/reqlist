package org.reqlist.service;

import org.reqlist.repository.UserRepository;
import java.util.Date;
import java.util.List;
import java.util.Set;
import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import org.reqlist.util.Hash;
import org.reqlist.arch.ValidatorProvider;
import org.reqlist.arch.exception.ResourceNotFoundException;
import org.reqlist.entity.User;
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
public class UserService {
    
//    @Autowired ValidatorProvider vp;
//    
//    @Autowired UserRepository repository;
//
//    public List<User> findAll() {
//        return repository.findAll();
//    }
//
//    public User getById(Long id) {
//        User user = repository.findOne(id);
//        
//        if ( isNull(user) ) {
//            throw new ResourceNotFoundException();
//        }
//        
//        return user;
//    }
//    
//    public String getAvatar(Long id) {
//        String email = repository.getUserEmail(id);
//        return "//gravatar.com/avatar/"+Hash.md5(email);
//    }
//
//    public User save(User user) {
//        user.setRegisterDate(new Date());
//        user.setConfirmed(false);
//        
//        validate(user);
//        
//        return repository.save(user);
//    }
//
//    private void validate(User user) {
//        Set<ConstraintViolation<User>> violations = vp.validator().validate(user);
//        
//        if ( !violations.isEmpty() ) {
//            throw new ConstraintViolationException(violations);
//        }
//    }
//    
//    public User update(User user) {
//        validate(user);
//        
//        return repository.save(user);
//    }
//    
//    @Transactional(propagation = Propagation.REQUIRED)
//    public void delete(Long id) {
//        User user = getById(id);
//        repository.delete(user);
//    }
    
}
