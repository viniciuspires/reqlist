/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package reqlist.entity;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import org.codehaus.jackson.annotate.JsonIgnoreProperties;
import org.hibernate.annotations.GeneratorType;

/**
 *
 * @author iran.freitas
 */
@Entity
@Table(name = "alocacao")
@NamedQueries({
    @NamedQuery(name = "Alocacao.findAll", query = "SELECT a FROM Alocacao a"),
    @NamedQuery(name = "Alocacao.findById", query = "SELECT a FROM Alocacao a WHERE a.id = :id"),
    @NamedQuery(name = "Alocacao.findByInicio", query = "SELECT a FROM Alocacao a WHERE a.inicio = :inicio"),
    @NamedQuery(name = "Alocacao.findByFim", query = "SELECT a FROM Alocacao a WHERE a.fim = :fim"),
    @NamedQuery(name = "Alocacao.findByTipo", query = "SELECT a FROM Alocacao a WHERE a.tipo = :tipo"),
    @NamedQuery(name = "Alocacao.findByEscopo",
        query="SELECT a FROM Alocacao a JOIN FETCH a.tarefa t JOIN FETCH t.requisitoId r JOIN FETCH r.escopoList e WHERE e.id = :escopoId")})
@JsonIgnoreProperties(ignoreUnknown = true)
public class Alocacao implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id")
    @GeneratedValue
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "inicio")
    @Temporal(TemporalType.TIMESTAMP)
    private Date inicio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fim")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fim;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tipo")
    private int tipo;
    @JoinColumn(name = "tarefa_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Tarefa tarefa;

    public Alocacao() {
    }

    public Alocacao(Integer id) {
        this.id = id;
    }

    public Alocacao(Integer id, Date inicio, Date fim, int tipo) {
        this.id = id;
        this.inicio = inicio;
        this.fim = fim;
        this.tipo = tipo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getInicio() {
        return inicio;
    }

    public void setInicio(Date inicio) {
        this.inicio = inicio;
    }

    public Date getFim() {
        return fim;
    }

    public void setFim(Date fim) {
        this.fim = fim;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public Tarefa getTarefa() {
        return tarefa;
    }

    public void setTarefa(Tarefa tarefa) {
        this.tarefa = tarefa;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Alocacao)) {
            return false;
        }
        Alocacao other = (Alocacao) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "reqlist.entity.Alocacao[ id=" + id + " ]";
    }
    
}
