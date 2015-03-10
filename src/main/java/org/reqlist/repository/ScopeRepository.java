package org.reqlist.repository;

import java.util.List;
import org.reqlist.entity.Scope;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Vinicius Pires <vinicius.costa.pires at gmail.com>
 */
@Repository
public interface ScopeRepository extends JpaRepository<Scope, Long>{

    @Query("FROM Scope s WHERE s.project.id = :id")
    public List<Scope> findAllByProject(@Param("id") Long id);

}
