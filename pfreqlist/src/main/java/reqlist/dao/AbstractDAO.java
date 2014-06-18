/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package reqlist.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

/**
 *
 * @author Vinicius
 * @param <T> Entity
 */
public abstract class AbstractDAO<T> {
    protected EntityManager em;
    
    public AbstractDAO(){
        em = Conexao.getEntityManager();
    }
 
    public void save(T entity) {
        em.persist(entity);
    }
    
    @Transactional
    public void update(T entity) {
        em.getTransaction().begin();
        try {
            em.merge(entity);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        }
    }
 
    public void delete(T entity) {
        em.remove(entity);
    }
    
    abstract List<T> findAll();
    
    public abstract T getById(Integer id);
}
