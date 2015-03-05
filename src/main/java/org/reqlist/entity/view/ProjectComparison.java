package org.reqlist.entity.view;

import java.io.Serializable;
import java.math.BigInteger;
import java.util.Date;
import java.util.Objects;
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

/**
 *
 * @author Vinicius
 */
@Entity
@Table(name = "vw_comparacao_projeto")
@NamedQueries({
    @NamedQuery(name = "ProjectComparison.findAll", query = "SELECT c FROM ProjectComparison c"),
    @NamedQuery(name = "ProjectComparison.findByProjetoId", query = "SELECT c FROM ProjectComparison c WHERE c.projetoId = :projetoId"),
    @NamedQuery(name = "ProjectComparison.findByProjetoNome", query = "SELECT c FROM ProjectComparison c WHERE c.projetoNome = :projetoNome"),
    @NamedQuery(name = "ProjectComparison.findByEscopoId", query = "SELECT c FROM ProjectComparison c WHERE c.escopoId = :escopoId"),
    @NamedQuery(name = "ProjectComparison.findByEscopoTitulo", query = "SELECT c FROM ProjectComparison c WHERE c.escopoTitulo = :escopoTitulo"),
    @NamedQuery(name = "ProjectComparison.findByData", query = "SELECT c FROM ProjectComparison c WHERE c.data = :data"),
    @NamedQuery(name = "ProjectComparison.findByHorasPlanejadas", query = "SELECT c FROM ProjectComparison c WHERE c.horasPlanejadas = :horasPlanejadas"),
    @NamedQuery(name = "ProjectComparison.findByHorasRealizadas", query = "SELECT c FROM ProjectComparison c WHERE c.horasRealizadas = :horasRealizadas")
})
public class ProjectComparison implements Serializable {
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
    @Column(name = "data")
    @Temporal(TemporalType.TIMESTAMP)
    private Date data;
    @Column(name = "horas_planejadas")
    private BigInteger horasPlanejadas;
    @Column(name = "horas_realizadas")
    private BigInteger horasRealizadas;

    public ProjectComparison() {
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

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
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
        hash = 79 * hash + this.projetoId;
        hash = 79 * hash + Objects.hashCode(this.projetoNome);
        hash = 79 * hash + this.escopoId;
        hash = 79 * hash + Objects.hashCode(this.escopoTitulo);
        hash = 79 * hash + Objects.hashCode(this.data);
        hash = 79 * hash + Objects.hashCode(this.horasPlanejadas);
        hash = 79 * hash + Objects.hashCode(this.horasRealizadas);
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
        final ProjectComparison other = (ProjectComparison) obj;
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
        if (!Objects.equals(this.data, other.data)) {
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
