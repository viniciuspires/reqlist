package org.reqlist.repository;

import java.util.List;
import org.reqlist.entity.Objective;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Vinicius Pires <vinicius.costa.pires at gmail.com>
 */
@Repository
public interface ObjectiveRepository extends JpaRepository<Objective, Long>{

    @Query("FROM Objective o WHERE o.project.id = :id")
    public List<Objective> findAllByProject(@Param("id") Long id);

}
