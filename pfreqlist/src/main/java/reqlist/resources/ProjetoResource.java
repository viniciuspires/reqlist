/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package reqlist.resources;

import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import reqlist.dao.ProjetoDAO;
import javax.ws.rs.core.MediaType;
import reqlist.entity.Projeto;

/**
 *
 * @author Iran
 */
@Path("/projeto")
public class ProjetoResource {
    private ProjetoDAO projetoDao;
    
    public ProjetoResource(){
        projetoDao = new ProjetoDAO();
    }
    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List getProjetos(){
        return projetoDao.findAll();
    }
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("{id}")
    public Projeto getProjeto(@PathParam("id") Integer id) {
        Projeto projeto = projetoDao.getById(id);
        if ( projeto == null ) {
            throw new NotFoundException();
        }
        return projeto;
    }
    
    @Path("{id}/escopo")
    public Class<EscopoResource> getEscopoResource() {
        return EscopoResource.class;
    }
}
