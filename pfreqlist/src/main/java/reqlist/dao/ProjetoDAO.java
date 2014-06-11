/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package reqlist.dao;

import java.util.List;
import javax.annotation.Resource;
import javax.inject.Inject;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import reqlist.entity.Projeto;

/**
 *
 * @author Iran
 */
@Resource
public class ProjetoDAO {

    private Session sessao;
    public ProjetoDAO() {        
        this.sessao = HibernateUtil.getSessionFactory().openSession();
    }


    public void adiciona(Projeto projeto) {
        Transaction tx = this.sessao.beginTransaction();
        this.sessao.save(projeto);
        tx.commit();
    }
    
    public void excluir(Projeto projeto) {
        Transaction tx = this.sessao.beginTransaction();
        this.sessao.delete(projeto);
        tx.commit();
    }

    public Projeto carrega(Projeto projeto) {
        return (Projeto) sessao.createCriteria(Projeto.class)
                .add(Restrictions.eq("id", projeto.getId()))
                .uniqueResult();
    }    
    public List<Projeto> listarTodos() {
        Criteria criteria = sessao.createCriteria(Projeto.class);
        return criteria.list();        
    }    
    
    public static void main (String []args){
        ProjetoDAO pj = new ProjetoDAO();
        System.out.println(pj.listarTodos());
    }
    
}
