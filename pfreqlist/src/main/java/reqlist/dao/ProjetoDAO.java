/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package reqlist.dao;

import java.util.List;
import javax.persistence.Query;
import reqlist.entity.Projeto;
import reqlist.entity.view.AndamentoProjeto;
import reqlist.entity.view.ComparacaoProjeto;

/**
 *
 * @author Iran
 */
public class ProjetoDAO extends AbstractDAO<Projeto> {
    public List<AndamentoProjeto> getAndamento(Integer projetoId) {
        Query query = em.createNamedQuery("AndamentoProjeto.findByProjetoId");
        query.setParameter("projetoId", projetoId);
        
        return query.getResultList(); 
    }

    public List<ComparacaoProjeto> getComparacao() {
        Query query = em.createNamedQuery("ComparacaoProjeto.findAll");
        
        return query.getResultList(); 
    }

    @Override
    Class<Projeto> getEntityClass() {
        return Projeto.class;
    }
}
