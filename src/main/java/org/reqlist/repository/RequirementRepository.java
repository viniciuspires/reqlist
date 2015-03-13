package org.reqlist.repository;

import java.util.List;
import org.reqlist.entity.Requirement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Vinicius Pires <vinicius.costa.pires at gmail.com>
 */
@Repository
public interface RequirementRepository extends JpaRepository<Requirement, Long> {
    
    @Query("FROM Requirement r JOIN FETCH r.scopes s WHERE s.id = :id")
    List<Requirement> findByScope(@Param("id") Long id);
    
}
