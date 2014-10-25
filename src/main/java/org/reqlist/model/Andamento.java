/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.reqlist.model;

import java.util.ArrayList;
import java.util.List;
import org.reqlist.entity.view.AndamentoProjeto;

/**
 *
 * @author Vinicius
 */
public class Andamento {
    private List<AndamentoEscopo> escopos;
    
    public Andamento( List<AndamentoProjeto> andamentoList ) {
        this.escopos = new ArrayList<>();
        for (AndamentoProjeto andamento : andamentoList) {
            AndamentoEscopo escopo = this.getEscopoById( andamento.getEscopoId() );
            if ( escopo == null ) {
                escopo = new AndamentoEscopo(andamento.getEscopoId(), andamento.getEscopoTitulo(), andamentoList);
                this.escopos.add(escopo);
            }
        }
    }
    
    private AndamentoEscopo getEscopoById(int escopoId) {
        AndamentoEscopo retorno = null;
        for (AndamentoEscopo escopo : this.escopos) {
            if ( escopo.getId() == escopoId ) {
                retorno = escopo;
                break;
            }
        }
        return retorno;
    }

    public List<AndamentoEscopo> getEscopos() {
        return escopos;
    }

    public void setEscopos(List<AndamentoEscopo> escopos) {
        this.escopos = escopos;
    }
}
