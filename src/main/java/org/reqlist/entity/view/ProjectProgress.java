/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.reqlist.entity.view;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Objects;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

/**
 *
 * @author Vinicius
 */
@Entity
@Table(name = "vw_andamento_projeto")
@NamedQueries({
    @NamedQuery(name = "ProjectProgress.findAll", query = "SELECT a FROM ProjectProgress a"),
    //@NamedQuery(name = "ProjectProgress.findByProjetoId", query = "SELECT a FROM ProjectProgress a WHERE a.projetoId = :projetoId"),
    @NamedQuery(name = "ProjectProgress.findByProjetoNome", query = "SELECT a FROM ProjectProgress a WHERE a.projetoNome = :projetoNome"),
    @NamedQuery(name = "ProjectProgress.findByEscopoId", query = "SELECT a FROM ProjectProgress a WHERE a.escopoId = :escopoId"),
    @NamedQuery(name = "ProjectProgress.findByEscopoTitulo", query = "SELECT a FROM ProjectProgress a WHERE a.escopoTitulo = :escopoTitulo"),
    @NamedQuery(name = "ProjectProgress.findByRequisitoId", query = "SELECT a FROM ProjectProgress a WHERE a.requisitoId = :requisitoId"),
    @NamedQuery(name = "ProjectProgress.findByRequisitoTitulo", query = "SELECT a FROM ProjectProgress a WHERE a.requisitoTitulo = :requisitoTitulo"),
    @NamedQuery(name = "ProjectProgress.findByTarefas", query = "SELECT a FROM ProjectProgress a WHERE a.tarefas = :tarefas"),
    @NamedQuery(name = "ProjectProgress.findByTarefasRealizadas", query = "SELECT a FROM ProjectProgress a WHERE a.tarefasRealizadas = :tarefasRealizadas"),
    @NamedQuery(name = "ProjectProgress.findByHorasPlanejadas", query = "SELECT a FROM ProjectProgress a WHERE a.horasPlanejadas = :horasPlanejadas"),
    @NamedQuery(name = "ProjectProgress.findByHorasRealizadas", query = "SELECT a FROM ProjectProgress a WHERE a.horasRealizadas = :horasRealizadas")})
public class ProjectProgress implements Serializable {
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

    public ProjectProgress() {
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
        int hash = 7;
        hash = 59 * hash + this.projetoId;
        hash = 59 * hash + Objects.hashCode(this.projetoNome);
        hash = 59 * hash + this.escopoId;
        hash = 59 * hash + Objects.hashCode(this.escopoTitulo);
        hash = 59 * hash + this.requisitoId;
        hash = 59 * hash + Objects.hashCode(this.requisitoTitulo);
        hash = 59 * hash + (int) (this.tarefas ^ (this.tarefas >>> 32));
        hash = 59 * hash + Objects.hashCode(this.tarefasRealizadas);
        hash = 59 * hash + Objects.hashCode(this.horasPlanejadas);
        hash = 59 * hash + Objects.hashCode(this.horasRealizadas);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ProjectProgress other = (ProjectProgress) obj;
        if (this.projetoId != other.projetoId) {
            return false;
        }
        if (!Objects.equals(this.projetoNome, other.projetoNome)) {
            return false;
        }
        if (this.escopoId != other.escopoId) {
            return false;
        }
        if (!Objects.equals(this.escopoTitulo, other.escopoTitulo)) {
            return false;
        }
        if (this.requisitoId != other.requisitoId) {
            return false;
        }
        if (!Objects.equals(this.requisitoTitulo, other.requisitoTitulo)) {
            return false;
        }
        if (this.tarefas != other.tarefas) {
            return false;
        }
        if (!Objects.equals(this.tarefasRealizadas, other.tarefasRealizadas)) {
            return false;
        }
        if (!Objects.equals(this.horasPlanejadas, other.horasPlanejadas)) {
            return false;
        }
        if (!Objects.equals(this.horasRealizadas, other.horasRealizadas)) {
            return false;
        }
        return true;
    }
    
    
    
}
