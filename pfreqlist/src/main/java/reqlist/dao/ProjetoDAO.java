/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package reqlist.dao;

import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import reqlist.entity.Projeto;

/**
 *
 * @author Iran
 */

public class ProjetoDAO {
    
    @Inject
    private EntityManager em;

    public Projeto getById(Integer id) {
        return (Projeto) em.find(Projeto.class, 1);
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
        return em.createQuery(("FROM " + Projeto.class))
                .getResultList();
    }    

    public static void main (String []args){
    }
    
}
