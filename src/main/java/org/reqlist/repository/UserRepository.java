package org.reqlist.repository;

import org.reqlist.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Vinicius Pires <vinicius.costa.pires at gmail.com>
 */
@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @Query("SELECT u.email FROM User u WHERE u.id = :id")
    String getUserEmail(@Param("id") Long id);
    
}
