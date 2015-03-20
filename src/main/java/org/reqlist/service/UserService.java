package org.reqlist.service;

import org.reqlist.repository.UserRepository;
import java.util.Date;
import java.util.List;
import org.reqlist.util.Hash;
import org.reqlist.arch.ValidatorProvider;
import org.reqlist.arch.exception.ResourceNotFoundException;
import org.reqlist.entity.Profile;
import org.reqlist.entity.User;
import org.reqlist.repository.ProfileRepository;
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
    
    public static final String GRAVATAR_URL_TEMPLATE = "https://gravatar.com/avatar/%s?size=400";
    
    @Autowired ValidatorProvider vp;
    @Autowired UserRepository repository;
    @Autowired ProfileRepository profileRepository;

    public List<Profile> findByProject(Long id) {
        List<Profile> profiles = profileRepository.findByProject(id);
        
        for (Profile profile : profiles) {
            postfixUser(profile.getUser());
        }
        
        return profiles;
    }

    public User get(Long id) {
        User user = repository.findOne(id);
        
        if ( isNull(user) ) {
            throw new ResourceNotFoundException();
        }
        
        postfixUser(user);
        
        return user;
    }

    /**
     * Registers a new user
     * 
     * TODO Send confirmation email
     * 
     * @param user
     * @return 
     */
    public User save(User user) {
        user.setRegisterDate(new Date());
        user.setConfirmed(false);
        
        String sha1 = Hash.sha1(user.getPassword());
        user.setPassword(sha1);
        
        vp.basicValidate(user);
        
        User newUser = repository.save(user);
        
        postfixUser(newUser);
        
        return newUser;
    }
    
    public User update(User user) {
        vp.basicValidate(user);
        
        return repository.save(user);
    }
    
    @Transactional(propagation = Propagation.REQUIRED)
    public void delete(Long id) {
        User user = get(id);
        repository.delete(user);
    }

    private void postfixUser(User user) {
        user.setPassword(null);
    }
}
