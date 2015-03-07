package org.reqlist.repository;

import org.reqlist.entity.Project;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Vinicius Pires <vinicius.costa.pires at gmail.com>
 */
@Repository
public interface ProjectRepository extends JpaRepository<Project, Integer>{

    /*@Query("SELECT a FROM ProjectProgress a WHERE a.projetoId = :id")
    public List<ProjectProgress> getProjectProgress(@Param("id") Integer id);

    @Query("SELECT c FROM ProjectComparison c")
    public List<ProjectComparison> getProjectComparison();*/

}
