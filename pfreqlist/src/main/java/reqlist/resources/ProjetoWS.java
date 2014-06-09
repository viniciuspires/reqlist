/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package reqlist.resources;

import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import reqlist.dao.ProjetoDAO;

/**
 *
 * @author Iran
 */
@Path("/projeto")
public class ProjetoWS {
    private ProjetoDAO projetoDao;
    
    @GET
    @Produces(javax.ws.rs.core.MediaType.APPLICATION_JSON)
    public List getProjetos(){
        projetoDao = new ProjetoDAO();
        return projetoDao.listarTodos();
    }
}
