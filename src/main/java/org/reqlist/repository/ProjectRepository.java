package org.reqlist.repository;

import java.util.List;
import org.reqlist.entity.Project;
import org.reqlist.entity.view.ProjectComparison;
import org.reqlist.entity.view.ProjectProgress;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Vinicius Pires <vinicius.costa.pires at gmail.com>
 */
@Repository
public interface ProjectRepository extends JpaRepository<Project, Integer>{

    @Query("SELECT a FROM ProjectProgress a WHERE a.projetoId = :id")
    public List<ProjectProgress> getProjectProgress(@Param("id") Integer id);

    @Query("SELECT c FROM ProjectComparison c")
    public List<ProjectComparison> getProjectComparison();

}
