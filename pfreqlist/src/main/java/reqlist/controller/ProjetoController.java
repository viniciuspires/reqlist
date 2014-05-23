package reqlist.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import reqlist.entity.Projeto;
import reqlist.service.ProjetoService;

/**
 *
 * @author Vinicius
 */
@Controller
@RequestMapping(value="/projeto")
public class ProjetoController {
    @Autowired
    ProjetoService projetoService;
    
    @RequestMapping(method=RequestMethod.GET,
            produces=MediaType.APPLICATION_JSON_VALUE)
    public List<Projeto> getProjetos(){
        return projetoService.getProjetos();
    }
}
