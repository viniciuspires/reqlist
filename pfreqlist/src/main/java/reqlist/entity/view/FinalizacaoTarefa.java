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
@Table(name = "vw_finalizacao_tarefa")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FinalizacaoTarefa.findAll", query = "SELECT f FROM FinalizacaoTarefa f"),
    @NamedQuery(name = "FinalizacaoTarefa.findByProjetoId", query = "SELECT f FROM FinalizacaoTarefa f WHERE f.projetoId = :projetoId"),
    @NamedQuery(name = "FinalizacaoTarefa.findByEscopoId", query = "SELECT f FROM FinalizacaoTarefa f WHERE f.escopoId = :escopoId"),
    @NamedQuery(name = "FinalizacaoTarefa.findByTarefaId", query = "SELECT f FROM FinalizacaoTarefa f WHERE f.tarefaId = :tarefaId"),
    @NamedQuery(name = "FinalizacaoTarefa.findByTitulo", query = "SELECT f FROM FinalizacaoTarefa f WHERE f.titulo = :titulo"),
    @NamedQuery(name = "FinalizacaoTarefa.findByTipo", query = "SELECT f FROM FinalizacaoTarefa f WHERE f.tipo = :tipo"),
    @NamedQuery(name = "FinalizacaoTarefa.findByFinalizacao", query = "SELECT f FROM FinalizacaoTarefa f WHERE f.finalizacao = :finalizacao"),
    @NamedQuery(name = "FinalizacaoTarefa.findByStatus", query = "SELECT f FROM FinalizacaoTarefa f WHERE f.status = :status")})
public class FinalizacaoTarefa implements Serializable {
    private static final long serialVersionUID = 1L;
    @Basic(optional = false)
    @NotNull
    @Column(name = "projeto_id")
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

    public FinalizacaoTarefa() {
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
    
}
