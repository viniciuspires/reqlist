/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.reqlist.dao;

import java.util.List;
import javax.persistence.Query;
import org.reqlist.entity.Escopo;
import org.reqlist.entity.Projeto;
import org.reqlist.entity.view.DataFinalizacao;
import org.reqlist.enumerated.TipoAlocacao;

/**
 * 
 * @author Vinicius
 */
public class EscopoDAO extends AbstractDAO<Escopo> {
    public List<Escopo> findByProjeto(Projeto projeto) {
        Query query = em.createNamedQuery("Escopo.findByProjeto");
        query.setParameter("projetoId", projeto.getId());
        return query.getResultList();
    }

    public List<DataFinalizacao> getBurndownPlanejamento(Integer id) {
        Query query = em.createNamedQuery("DataFinalizacao.findByEscopoAndTipo");
        query.setParameter("escopoId", id);
        query.setParameter("tipo", TipoAlocacao.PLANEJAMENTO);
        return query.getResultList();
    }
    
    public List<DataFinalizacao> getBurndownRealizacao(Integer id) {
        Query query = em.createNamedQuery("DataFinalizacao.findByEscopoAndTipo");
        query.setParameter("escopoId", id);
        query.setParameter("tipo", TipoAlocacao.REALIZACAO);
        return query.getResultList();
    }

    @Override
    Class<Escopo> getEntityClass() {
        return Escopo.class;
    }
}
