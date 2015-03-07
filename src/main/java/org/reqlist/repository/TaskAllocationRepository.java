package org.reqlist.repository;

import java.util.List;
import org.reqlist.entity.TaskAllocation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Vinicius Pires <vinicius.costa.pires at gmail.com>
 */
@Repository
public interface TaskAllocationRepository extends JpaRepository<TaskAllocation, Integer>{
    
    @Query("FROM TaskAllocation a JOIN FETCH a.task t JOIN t.requirement r JOIN FETCH r.scopes s WHERE s.id = :id")
    List<TaskAllocation> findByEscopo(@Param("id") Integer scopeId);
    
}
