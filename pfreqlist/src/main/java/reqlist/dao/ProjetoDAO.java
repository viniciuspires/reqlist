/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package reqlist.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import reqlist.entity.Projeto;
import reqlist.entity.view.AndamentoProjeto;

/**
 *
 * @author Iran
 */
public class ProjetoDAO {
    
    private EntityManager em;
    
    public ProjetoDAO(){
        em = Conexao.getEntityManager();
    }

    public Projeto getById(Integer id) {
        return em.find(Projeto.class, id);
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
        Query query = em.createNamedQuery("Projeto.findAll") ;
        return query.getResultList(); 
    }

    public List<AndamentoProjeto> getAndamento(Integer projetoId) {
        Query query = em.createNamedQuery("AndamentoProjeto.findByProjetoId");
        query.setParameter("projetoId", projetoId);
        
        return query.getResultList(); 
    }
}
