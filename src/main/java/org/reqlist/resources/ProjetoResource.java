package org.reqlist.resources;

import java.util.List;
import javax.ws.rs.GET;
import javax.ws.rs.NotFoundException;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import org.reqlist.dao.ProjetoDAO;
import org.reqlist.entity.Projeto;
import org.reqlist.model.Andamento;
import org.reqlist.model.PerformanceComparacao;

@Path("projeto")
@Produces("application/json; charset=utf-8")
public class ProjetoResource {
    ProjetoDAO dao = new ProjetoDAO();
    
    @GET
    public List getProjetos(){
        return dao.findAll();
    }
    
    @GET
    @Path("{id}")
    public Projeto getProjeto(@PathParam("id") Integer id) {
        Projeto projeto = dao.getById(id);
        if ( projeto == null ) {
            throw new NotFoundException();
        }
        return projeto;
    }
    
    @GET
    @Path("{id}/andamento")
    public Andamento getAndamentoProjeto(@PathParam("id") Integer id) {
        return new Andamento( dao.getAndamento(id) );
    }
    
    @GET
    @Path("comparacao")
    public PerformanceComparacao getComparacaoProjetos() {
        return new PerformanceComparacao( dao.getComparacao() );
    }
    
    // Subresources
    @Path("{id}/escopo")
    public EscopoResource getEscopoResource(@PathParam("id") Integer id) {
        EscopoResource escopoResource = new EscopoResource();
        escopoResource.setProjeto( new Projeto(id) );
        return escopoResource;
    }
    @Path("{id}/objetivo")
    public ObjetivoResource getObjetivoResource(@PathParam("id") Integer id) {
        ObjetivoResource objetivoResource = new ObjetivoResource();
        objetivoResource.setProjeto( new Projeto(id) );
        return objetivoResource;
    }
}