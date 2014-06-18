/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package reqlist.dao;

import java.util.List;
import javax.persistence.Query;
import reqlist.entity.Escopo;
import reqlist.entity.Requisito;

/**
 *
 * @author Vinicius
 */
public class RequisitoDAO extends AbstractDAO<Requisito> {
    
    @Override
    public Requisito getById(Integer id) {
        return super.em.find(Requisito.class, id);
    }
 
    @Override
    public List<Requisito> findAll() {
        Query query = em.createNamedQuery("Requisito.findAll");
        return query.getResultList();
    }

    public List<Requisito> findByEscopo(Escopo escopo) {
        Query query = em.createNamedQuery("Requisito.findByEscopo");
        query.setParameter("escopoId", escopo.getId());
        return query.getResultList();
    }
}
