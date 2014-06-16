/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package reqlist.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import reqlist.entity.Escopo;
import reqlist.entity.Projeto;

/**
 * 
 * @author Vinicius
 */
public class EscopoDAO {
    
    private EntityManager em;
    
    public EscopoDAO(){
        em = ConexaoDAO.getEntityManager();
    }

    public Escopo getById(Integer id) {
        return em.find(Escopo.class, id);
    }
 
    public void save(Projeto entity) {
        em.persist(entity);
    }
 
    public void update(Projeto entity) {
        em.merge(entity);
    }
 
    public void delete(Projeto entity) {
        em.remove(entity);
    }
 
    public List<Projeto> findAll() {
        Query query = em.createNamedQuery ("Projeto.findAll") ;
        return query.getResultList(); 
    }
}
