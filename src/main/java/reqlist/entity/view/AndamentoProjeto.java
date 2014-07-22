/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package reqlist.entity.view;

import java.io.Serializable;
import java.math.BigInteger;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Vinicius
 */
@Entity
@Table(name = "vw_andamento_projeto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AndamentoProjeto.findAll", query = "SELECT a FROM AndamentoProjeto a"),
    @NamedQuery(name = "AndamentoProjeto.findByProjetoId", query = "SELECT a FROM AndamentoProjeto a WHERE a.projetoId = :projetoId"),
    @NamedQuery(name = "AndamentoProjeto.findByProjetoNome", query = "SELECT a FROM AndamentoProjeto a WHERE a.projetoNome = :projetoNome"),
    @NamedQuery(name = "AndamentoProjeto.findByEscopoId", query = "SELECT a FROM AndamentoProjeto a WHERE a.escopoId = :escopoId"),
    @NamedQuery(name = "AndamentoProjeto.findByEscopoTitulo", query = "SELECT a FROM AndamentoProjeto a WHERE a.escopoTitulo = :escopoTitulo"),
    @NamedQuery(name = "AndamentoProjeto.findByRequisitoId", query = "SELECT a FROM AndamentoProjeto a WHERE a.requisitoId = :requisitoId"),
    @NamedQuery(name = "AndamentoProjeto.findByRequisitoTitulo", query = "SELECT a FROM AndamentoProjeto a WHERE a.requisitoTitulo = :requisitoTitulo"),
    @NamedQuery(name = "AndamentoProjeto.findByTarefas", query = "SELECT a FROM AndamentoProjeto a WHERE a.tarefas = :tarefas"),
    @NamedQuery(name = "AndamentoProjeto.findByTarefasRealizadas", query = "SELECT a FROM AndamentoProjeto a WHERE a.tarefasRealizadas = :tarefasRealizadas"),
    @NamedQuery(name = "AndamentoProjeto.findByHorasPlanejadas", query = "SELECT a FROM AndamentoProjeto a WHERE a.horasPlanejadas = :horasPlanejadas"),
    @NamedQuery(name = "AndamentoProjeto.findByHorasRealizadas", query = "SELECT a FROM AndamentoProjeto a WHERE a.horasRealizadas = :horasRealizadas")})
public class AndamentoProjeto implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "projeto_id")
    @Id
    private int projetoId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "projeto_nome")
    private String projetoNome;
    @Basic(optional = false)
    @NotNull
    @Column(name = "escopo_id")
    @Id
    private int escopoId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 128)
    @Column(name = "escopo_titulo")
    private String escopoTitulo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "requisito_id")
    @Id
    private int requisitoId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 128)
    @Column(name = "requisito_titulo")
    private String requisitoTitulo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tarefas")
    private long tarefas;
    @Column(name = "tarefas_realizadas")
    private BigInteger tarefasRealizadas;
    @Column(name = "horas_planejadas")
    private BigInteger horasPlanejadas;
    @Column(name = "horas_realizadas")
    private BigInteger horasRealizadas;

    public AndamentoProjeto() {
    }

    public int getProjetoId() {
        return projetoId;
    }

    public void setProjetoId(int projetoId) {
        this.projetoId = projetoId;
    }

    public String getProjetoNome() {
        return projetoNome;
    }

    public void setProjetoNome(String projetoNome) {
        this.projetoNome = projetoNome;
    }

    public int getEscopoId() {
        return escopoId;
    }

    public void setEscopoId(int escopoId) {
        this.escopoId = escopoId;
    }

    public String getEscopoTitulo() {
        return escopoTitulo;
    }

    public void setEscopoTitulo(String escopoTitulo) {
        this.escopoTitulo = escopoTitulo;
    }

    public int getRequisitoId() {
        return requisitoId;
    }

    public void setRequisitoId(int requisitoId) {
        this.requisitoId = requisitoId;
    }

    public String getRequisitoTitulo() {
        return requisitoTitulo;
    }

    public void setRequisitoTitulo(String requisitoTitulo) {
        this.requisitoTitulo = requisitoTitulo;
    }

    public long getTarefas() {
        return tarefas;
    }

    public void setTarefas(long tarefas) {
        this.tarefas = tarefas;
    }

    public BigInteger getTarefasRealizadas() {
        return tarefasRealizadas;
    }

    public void setTarefasRealizadas(BigInteger tarefasRealizadas) {
        this.tarefasRealizadas = tarefasRealizadas;
    }

    public BigInteger getHorasPlanejadas() {
        return horasPlanejadas;
    }

    public void setHorasPlanejadas(BigInteger horasPlanejadas) {
        this.horasPlanejadas = horasPlanejadas;
    }

    public BigInteger getHorasRealizadas() {
        return horasRealizadas;
    }

    public void setHorasRealizadas(BigInteger horasRealizadas) {
        this.horasRealizadas = horasRealizadas;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 53 * hash + this.projetoId;
        hash = 53 * hash + this.escopoId;
        hash = 53 * hash + this.requisitoId;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        return false;
        /*if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final AndamentoProjeto other = (AndamentoProjeto) obj;
        if (this.projetoId != other.projetoId) {
            return false;
        }
        if (this.escopoId != other.escopoId) {
            return false;
        }
        if (this.requisitoId != other.requisitoId) {
            return false;
        }
        return true;*/
    }
}
