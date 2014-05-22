package reqlist.repository;

import java.util.List;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import reqlist.entity.Projeto;

/**
 *
 * @author Vinicius
 */
@Repository
public interface ProjetoRepository {
    
    //@PersistenceContext
    //public EntityManager manager;
    @Query("SELECT p FROM Projeto p")
    public List<Projeto> findAll();
}
