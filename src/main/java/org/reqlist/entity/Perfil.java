/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package org.reqlist.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Vinicius
 */
@Entity
@Table(name = "perfil")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Perfil.findAll", query = "SELECT p FROM Perfil p"),
    @NamedQuery(name = "Perfil.findByUsuarioId", query = "SELECT p FROM Perfil p WHERE p.perfilPK.usuarioId = :usuarioId"),
    @NamedQuery(name = "Perfil.findByProjetoId", query = "SELECT p FROM Perfil p WHERE p.perfilPK.projetoId = :projetoId"),
    @NamedQuery(name = "Perfil.findByPapel", query = "SELECT p FROM Perfil p WHERE p.papel = :papel")})
public class Perfil implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected PerfilPK perfilPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "papel")
    private int papel;
    @JoinColumn(name = "usuario_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Usuario usuario;
    @JoinColumn(name = "projeto_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Projeto projeto;

    public Perfil() {
    }

    public Perfil(PerfilPK perfilPK) {
        this.perfilPK = perfilPK;
    }

    public Perfil(PerfilPK perfilPK, int papel) {
        this.perfilPK = perfilPK;
        this.papel = papel;
    }

    public Perfil(int usuarioId, int projetoId) {
        this.perfilPK = new PerfilPK(usuarioId, projetoId);
    }

    public PerfilPK getPerfilPK() {
        return perfilPK;
    }

    public void setPerfilPK(PerfilPK perfilPK) {
        this.perfilPK = perfilPK;
    }

    public int getPapel() {
        return papel;
    }

    public void setPapel(int papel) {
        this.papel = papel;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
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
        hash += (perfilPK != null ? perfilPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Perfil)) {
            return false;
        }
        Perfil other = (Perfil) object;
        if ((this.perfilPK == null && other.perfilPK != null) || (this.perfilPK != null && !this.perfilPK.equals(other.perfilPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "reqlist.entity.Perfil[ perfilPK=" + perfilPK + " ]";
    }
    
}
