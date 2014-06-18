/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package reqlist.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlTransient;

@Entity
@Table(name = "escopo")
@NamedQueries({
    @NamedQuery(name = "Escopo.findAll", query = "SELECT e FROM Escopo e"),
    @NamedQuery(name = "Escopo.findById", query = "SELECT e FROM Escopo e WHERE e.id = :id"),
    @NamedQuery(name = "Escopo.findByTitulo", query = "SELECT e FROM Escopo e WHERE e.titulo = :titulo"),
    @NamedQuery(name = "Escopo.findByData", query = "SELECT e FROM Escopo e WHERE e.data = :data"),
    @NamedQuery(name = "Escopo.findByStatus", query = "SELECT e FROM Escopo e WHERE e.status = :status"),
    @NamedQuery(name = "Escopo.findByProjeto", query = "SELECT e FROM Escopo e WHERE e.projeto.id = :projetoId")})
public class Escopo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 128)
    @Column(name = "titulo")
    private String titulo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "data")
    @Temporal(TemporalType.TIMESTAMP)
    private Date data;
    @Basic(optional = false)
    @NotNull
    @Column(name = "status")
    private int status;
    @JoinTable(name = "escopo_x_requisito", joinColumns = {
        @JoinColumn(name = "escopo_id", referencedColumnName = "id")}, inverseJoinColumns = {
        @JoinColumn(name = "requisito_id", referencedColumnName = "id")})
    @ManyToMany
    private List<Requisito> requisitoList;
    @JoinColumn(name = "projeto_id", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Projeto projeto;

    public Escopo() {
    }

    public Escopo(Integer id) {
        this.id = id;
    }

    public Escopo(Integer id, String titulo, Date data, int status) {
        this.id = id;
        this.titulo = titulo;
        this.data = data;
        this.status = status;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    @XmlTransient
    public List<Requisito> getRequisitoList() {
        return requisitoList;
    }

    public void setRequisitoList(List<Requisito> requisitoList) {
        this.requisitoList = requisitoList;
    }

    public Projeto getProjeto() {
        return projeto;
    }

    public void setProjeto(Projeto projeto) {
        this.projeto = projeto;
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
        if (!(object instanceof Escopo)) {
            return false;
        }
        Escopo other = (Escopo) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "reqlist.entity.Escopo[ id=" + id + " ]";
    }
    
}
