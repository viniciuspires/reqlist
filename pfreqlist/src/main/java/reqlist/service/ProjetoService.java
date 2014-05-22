package reqlist.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reqlist.entity.Projeto;
import reqlist.repository.ProjetoRepository;

/**
 *
 * @author Vinicius
 */
@Service
public class ProjetoService {
    
    @Autowired
    ProjetoRepository projetoRepository;
    
    public List<Projeto> getProjetos(){
        return projetoRepository.findAll();
    }
}
