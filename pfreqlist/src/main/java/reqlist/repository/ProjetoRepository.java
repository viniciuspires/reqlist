package reqlist.repository;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import org.hibernate.jpa.internal.QueryImpl;
import org.springframework.stereotype.Repository;
import reqlist.entity.Projeto;

/**
 *
 * @author Vinicius
 */
@Repository
public class ProjetoRepository {
    
    //@PersistenceContext
    //public EntityManager manager;
    
    public List<Projeto> findAll() {
        //TypedQuery<Projeto> q = manager.createQuery("SELECT p FROM Projeto p", Projeto.class);
        //return q.getResultList();
        return null;
    }
}
