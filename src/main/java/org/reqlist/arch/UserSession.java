package org.reqlist.arch;

import org.reqlist.entity.User;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import org.springframework.web.context.WebApplicationContext;

/**
 *
 * @author Vinicius Pires <vinicius.costa.pires at gmail.com>
 */
@Component
//@Scope(WebApplicationContext.SCOPE_SESSION)
public class UserSession {
    
    private final User user;

    public UserSession() {
        user = new User();
        user.setId(10L);
        /*user.setName("Random user");
        user.setEmail("wh@tevs.com");
        user.setRegisterDate(new Date());
        user.setConfirmed(true);
        user.setSenha("123456");*/
    }

    /**
     * Returns the logged in {@link User}
     
     * FIXME MOCK
     * @return 
     */
    public User getLoggedInUser() {
        return user;
    }

}
