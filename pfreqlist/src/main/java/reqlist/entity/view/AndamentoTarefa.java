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
@Table(name = "vw_andamento_tarefa")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AndamentoTarefa.findAll", query = "SELECT a FROM AndamentoTarefa a"),
    @NamedQuery(name = "AndamentoTarefa.findByProjetoId", query = "SELECT a FROM AndamentoTarefa a WHERE a.projetoId = :projetoId"),
    @NamedQuery(name = "AndamentoTarefa.findByProjetoNome", query = "SELECT a FROM AndamentoTarefa a WHERE a.projetoNome = :projetoNome"),
    @NamedQuery(name = "AndamentoTarefa.findByEscopoId", query = "SELECT a FROM AndamentoTarefa a WHERE a.escopoId = :escopoId"),
    @NamedQuery(name = "AndamentoTarefa.findByEscopoTitulo", query = "SELECT a FROM AndamentoTarefa a WHERE a.escopoTitulo = :escopoTitulo"),
    @NamedQuery(name = "AndamentoTarefa.findByRequisitoId", query = "SELECT a FROM AndamentoTarefa a WHERE a.requisitoId = :requisitoId"),
    @NamedQuery(name = "AndamentoTarefa.findByRequisitoTitulo", query = "SELECT a FROM AndamentoTarefa a WHERE a.requisitoTitulo = :requisitoTitulo"),
    @NamedQuery(name = "AndamentoTarefa.findByTarefas", query = "SELECT a FROM AndamentoTarefa a WHERE a.tarefas = :tarefas"),
    @NamedQuery(name = "AndamentoTarefa.findByTarefasRealizadas", query = "SELECT a FROM AndamentoTarefa a WHERE a.tarefasRealizadas = :tarefasRealizadas")})
public class AndamentoTarefa implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Column(name = "projeto_id")
    private int projetoId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "projeto_nome")
    private String projetoNome;
    @Basic(optional = false)
    @NotNull
    @Column(name = "escopo_id")
    private int escopoId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 128)
    @Column(name = "escopo_titulo")
    private String escopoTitulo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "requisito_id")
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

    public AndamentoTarefa() {
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
    
}
