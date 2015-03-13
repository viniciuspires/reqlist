/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.reqlist.model;

import java.util.ArrayList;
import java.util.List;
import org.reqlist.entity.view.ProjectComparison;

/**
 *
 * @author Vinicius
 */
public class PerformanceComparison {
    private List<ProjectPerformance> projetos;

    public PerformanceComparison(List<ProjectComparison> comparacaoList) {
        this.projetos = new ArrayList<>();
        for (ProjectComparison comparacaoProjeto : comparacaoList) {
            ProjectPerformance projeto = this.getProjetoById( comparacaoProjeto.getProjetoId() );
            if ( projeto == null ) {
                projeto = new ProjectPerformance(comparacaoProjeto);
                this.projetos.add(projeto);
            } else if ( comparacaoProjeto.getEscopoId()> projeto.getEscopoId() ) {
                int indice = this.projetos.indexOf(projeto);
                projeto = new ProjectPerformance(comparacaoProjeto);
                this.projetos.set(indice, projeto);
            }
        }
    }
    
    private ProjectPerformance getProjetoById(Integer id){
        ProjectPerformance projeto = null;
        for (ProjectPerformance performanceProjeto : projetos) {
            if ( performanceProjeto.getId().equals(id) ) {
                projeto = performanceProjeto;
                break;
            }
        }
        return projeto;
    }

    public List<ProjectPerformance> getProjetos() {
        return projetos;
    }

    public void setProjetos(List<ProjectPerformance> projetos) {
        this.projetos = projetos;
    }
}
