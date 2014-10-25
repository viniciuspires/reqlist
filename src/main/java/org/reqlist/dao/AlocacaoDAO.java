/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.reqlist.dao;

import java.util.List;
import javax.persistence.Query;
import org.reqlist.entity.Alocacao;
import org.reqlist.entity.Escopo;

/**
 *
 * @author Vinicius
 */
public class AlocacaoDAO extends AbstractDAO<Alocacao> {
    public List<Alocacao> findByEscopo(Escopo escopo) {
        Query query = em.createNamedQuery("Alocacao.findByEscopo");
        query.setParameter("escopoId", escopo.getId());
        return query.getResultList();
    }

    @Override
    Class<Alocacao> getEntityClass() {
        return Alocacao.class;
    }
}
