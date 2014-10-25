/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.reqlist.dao;

import java.util.List;
import javax.persistence.Query;
import org.reqlist.entity.Escopo;
import org.reqlist.entity.Requisito;

/**
 *
 * @author Vinicius
 */
public class RequisitoDAO extends AbstractDAO<Requisito> {
    public List<Requisito> findByEscopo(Escopo escopo) {
        Query query = em.createNamedQuery("Requisito.findByEscopo");
        query.setParameter("escopoId", escopo.getId());
        return query.getResultList();
    }

    @Override
    Class<Requisito> getEntityClass() {
        return Requisito.class;
    }
}
