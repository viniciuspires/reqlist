/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.reqlist.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
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
    
    @Transactional
    public void save(T entity) {
        em.getTransaction().begin();
        try {
            em.persist(entity);
            em.getTransaction().commit();
        } catch (Exception e) {
            em.getTransaction().rollback();
            throw e;
        }
    }
    
    @Transactional
    public void update(T entity) throws Exception {
        em.getTransaction().begin();
        em.merge(entity);
        em.getTransaction().commit();
    }
 
    @Transactional(Transactional.TxType.REQUIRED)
    public void delete(T entity) {
        em.remove(entity);
    }
    
    @Transactional(Transactional.TxType.REQUIRED)
    public List<T> findAll() {
        String string = "FROM "+getEntityClass().getName();
        Query query = em.createQuery(string);
        return query.getResultList();
    }
    
    @Transactional(Transactional.TxType.REQUIRED)
    public T getById(Integer id){
        return em.find(getEntityClass(), id);
    }
    
    abstract Class<T> getEntityClass();
}
