/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package reqlist.dao;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import reqlist.entity.Objetivo;
import reqlist.entity.Projeto;

/**
 *
 * @author Vinicius
 */
public class EntregaDAO {
    private EntityManager em;
    
    public EntregaDAO(){
        em = Conexao.getEntityManager();
    }
    
    public Objetivo getById(Integer id) {
        return em.find(Objetivo.class, id);
    }
 
    public void save(Objetivo entity) {
        em.persist(entity);
    }
 
    public void update(Objetivo entity) {
        em.merge(entity);
    }
 
    public void delete(Objetivo entity) {
        em.remove(entity);
    }
 
    public List<Objetivo> findAll() {
        Query query = em.createNamedQuery("Objetivo.findAll");
        return query.getResultList();
    }

    public List<Objetivo> findByProjeto(Projeto projeto) {
        Query query = em.createNamedQuery("Objetivo.findByProjeto");
        query.setParameter("projetoId", projeto.getId());
        return query.getResultList();
    }
}
