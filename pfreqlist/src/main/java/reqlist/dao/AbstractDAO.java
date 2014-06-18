/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package reqlist.dao;

import java.util.List;
import javax.persistence.EntityManager;

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
 
    public void update(T entity) {
        em.merge(entity);
    }
 
    public void delete(T entity) {
        em.remove(entity);
    }
    
    abstract List<T> findAll();
    
    public abstract T getById(Integer id);
}
