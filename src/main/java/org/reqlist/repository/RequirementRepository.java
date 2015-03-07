package org.reqlist.repository;

import java.util.List;
import org.reqlist.entity.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Vinicius Pires <vinicius.costa.pires at gmail.com>
 */
@Repository
public interface RequirementRepository extends JpaRepository<Task, Long> {
    
    @Query("SELECT r FROM Requirement r JOIN FETCH r.scopes s WHERE s.id = :id")
    List<Task> findByScope(@Param("id") Long id);
    
}
