/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package reqlist.entity.view;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Vinicius
 */
@Entity
@Table(name = "vw_data_finalizacao")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "DataFinalizacao.findAll", query = "SELECT d FROM DataFinalizacao d"),
    @NamedQuery(name = "DataFinalizacao.findByProjetoId", query = "SELECT d FROM DataFinalizacao d WHERE d.projetoId = :projetoId"),
    @NamedQuery(name = "DataFinalizacao.findByEscopoId", query = "SELECT d FROM DataFinalizacao d WHERE d.escopoId = :escopoId"),
    @NamedQuery(name = "DataFinalizacao.findByTarefaId", query = "SELECT d FROM DataFinalizacao d WHERE d.tarefaId = :tarefaId"),
    @NamedQuery(name = "DataFinalizacao.findByTitulo", query = "SELECT d FROM DataFinalizacao d WHERE d.titulo = :titulo"),
    @NamedQuery(name = "DataFinalizacao.findByTipo", query = "SELECT d FROM DataFinalizacao d WHERE d.tipo = :tipo"),
    @NamedQuery(name = "DataFinalizacao.findByFinalizacao", query = "SELECT d FROM DataFinalizacao d WHERE d.finalizacao = :finalizacao"),
    @NamedQuery(name = "DataFinalizacao.findByStatus", query = "SELECT d FROM DataFinalizacao d WHERE d.status = :status"),
    @NamedQuery(name = "DataFinalizacao.findByTarefasConcluidas", query = "SELECT d FROM DataFinalizacao d WHERE d.tarefasConcluidas = :tarefasConcluidas")})
public class DataFinalizacao implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Column(name = "projeto_id")
    @Id
    private int projetoId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "escopo_id")
    private int escopoId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tarefa_id")
    private int tarefaId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 128)
    @Column(name = "titulo")
    private String titulo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tipo")
    private int tipo;
    @Column(name = "finalizacao")
    @Temporal(TemporalType.TIMESTAMP)
    private Date finalizacao;
    @Basic(optional = false)
    @NotNull
    @Column(name = "status")
    private int status;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tarefas_concluidas")
    private long tarefasConcluidas;

    public DataFinalizacao() {
    }

    public int getProjetoId() {
        return projetoId;
    }

    public void setProjetoId(int projetoId) {
        this.projetoId = projetoId;
    }

    public int getEscopoId() {
        return escopoId;
    }

    public void setEscopoId(int escopoId) {
        this.escopoId = escopoId;
    }

    public int getTarefaId() {
        return tarefaId;
    }

    public void setTarefaId(int tarefaId) {
        this.tarefaId = tarefaId;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public int getTipo() {
        return tipo;
    }

    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    public Date getFinalizacao() {
        return finalizacao;
    }

    public void setFinalizacao(Date finalizacao) {
        this.finalizacao = finalizacao;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public long getTarefasConcluidas() {
        return tarefasConcluidas;
    }

    public void setTarefasConcluidas(long tarefasConcluidas) {
        this.tarefasConcluidas = tarefasConcluidas;
    }
    
}
