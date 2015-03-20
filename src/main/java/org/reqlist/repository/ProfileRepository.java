package org.reqlist.repository;

import java.util.List;
import org.reqlist.entity.Profile;
import org.reqlist.entity.ProfileKey;
import org.reqlist.enumerated.RoleEnum;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Vinicius Pires <vinicius.costa.pires at gmail.com>
 */
@Repository
public interface ProfileRepository extends JpaRepository<Profile, ProfileKey> {

    @Query("FROM Profile p WHERE p.profileKey.userId = :id")
    List<Profile> findByUser(@Param("id") Long userId);
    
    @Query("FROM Profile p JOIN FETCH p.user u WHERE p.profileKey.projectId = :id")
    List<Profile> findByProject(@Param("id") Long userId);
    
    @Query("FROM Profile p WHERE p.role = :role")
    List<Profile> findByRole(@Param("role") RoleEnum role);
    
}
