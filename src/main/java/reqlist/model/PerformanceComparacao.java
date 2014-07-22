/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package reqlist.model;

import java.util.ArrayList;
import java.util.List;
import reqlist.entity.view.ComparacaoProjeto;

/**
 *
 * @author Vinicius
 */
public class PerformanceComparacao {
    private List<PerformanceProjeto> projetos;

    public PerformanceComparacao(List<ComparacaoProjeto> comparacaoList) {
        this.projetos = new ArrayList<>();
        for (ComparacaoProjeto comparacaoProjeto : comparacaoList) {
            PerformanceProjeto projeto = this.getProjetoById( comparacaoProjeto.getProjetoId() );
            if ( projeto == null ) {
                projeto = new PerformanceProjeto(comparacaoProjeto);
                this.projetos.add(projeto);
            } else if ( comparacaoProjeto.getEscopoId()> projeto.getEscopoId() ) {
                int indice = this.projetos.indexOf(projeto);
                projeto = new PerformanceProjeto(comparacaoProjeto);
                this.projetos.set(indice, projeto);
            }
        }
    }
    
    private PerformanceProjeto getProjetoById(Integer id){
        PerformanceProjeto projeto = null;
        for (PerformanceProjeto performanceProjeto : projetos) {
            if ( performanceProjeto.getId().equals(id) ) {
                projeto = performanceProjeto;
                break;
            }
        }
        return projeto;
    }

    public List<PerformanceProjeto> getProjetos() {
        return projetos;
    }

    public void setProjetos(List<PerformanceProjeto> projetos) {
        this.projetos = projetos;
    }
}
