/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package reqlist.dao;

import java.util.List;
import javax.persistence.Query;
import reqlist.entity.Objetivo;
import reqlist.entity.Projeto;

/**
 *
 * @author Vinicius
 */
public class ObjetivoDAO extends AbstractDAO<Objetivo> {
    public List<Objetivo> findByProjeto(Projeto projeto) {
        Query query = em.createNamedQuery("Objetivo.findByProjeto");
        query.setParameter("projetoId", projeto.getId());
        return query.getResultList();
    }

    @Override
    Class<Objetivo> getEntityClass() {
        return Objetivo.class;
    }
}
