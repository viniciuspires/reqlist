/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reqlist.dao;

import java.util.List;
import javax.persistence.Query;
import reqlist.entity.Escopo;
import reqlist.entity.Tarefa;

/**
 *
 * @author Vinicius
 */
public class TarefaDAO extends AbstractDAO<Tarefa> {

    public List<Tarefa> findByEscopo(Escopo escopo) {
        Query query = em.createNamedQuery("Tarefa.findByEscopo");
        query.setParameter("escopoId", escopo.getId());
        return query.getResultList();
    }

    @Override
    Class<Tarefa> getEntityClass() {
        return Tarefa.class;
    }

}
