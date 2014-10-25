/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.reqlist.dao;

import java.util.List;
import javax.persistence.Query;
import org.reqlist.entity.Entrega;
import org.reqlist.entity.Objetivo;
import org.reqlist.entity.Projeto;

/**
 *
 * @author Vinicius
 */
public class EntregaDAO extends AbstractDAO<Entrega> {
    public List<Objetivo> findByProjeto(Projeto projeto) {
        Query query = em.createNamedQuery("Objetivo.findByProjeto");
        query.setParameter("projetoId", projeto.getId());
        return query.getResultList();
    }

    @Override
    Class<Entrega> getEntityClass() {
        return Entrega.class;
    }
}