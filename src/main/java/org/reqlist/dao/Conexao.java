/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.reqlist.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Iran
 */
public class Conexao {
    private static EntityManager em;
    
    /**
     * Lazy loading da conexão
     * @return EntityManager
     */
    public static EntityManager getEntityManager() {
        if ( em == null ) {
            EntityManagerFactory factory = Persistence.createEntityManagerFactory("ReqlistPU");
            em = factory.createEntityManager();
        }
        return em;
    }
    
    @Override
    protected void finalize() throws Throwable {
        em.close();
        em = null;
        super.finalize();
    }
}
