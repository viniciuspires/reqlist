/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package reqlist.entity;

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
 * @author iran.freitas
 */
@Entity
@Table(name = "usuario_x_projeto")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "UsuarioXProjeto.findAll", query = "SELECT u FROM UsuarioXProjeto u"),
    @NamedQuery(name = "UsuarioXProjeto.findByUsuarioId", query = "SELECT u FROM UsuarioXProjeto u WHERE u.usuarioXProjetoPK.usuarioId = :usuarioId"),
    @NamedQuery(name = "UsuarioXProjeto.findByProjetoId", query = "SELECT u FROM UsuarioXProjeto u WHERE u.usuarioXProjetoPK.projetoId = :projetoId"),
    @NamedQuery(name = "UsuarioXProjeto.findByPapel", query = "SELECT u FROM UsuarioXProjeto u WHERE u.papel = :papel")})
public class UsuarioXProjeto implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected UsuarioXProjetoPK usuarioXProjetoPK;
    @Basic(optional = false)
    @NotNull
    @Column(name = "papel")
    private int papel;
    @JoinColumn(name = "projeto_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Projeto projeto;
    @JoinColumn(name = "usuario_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Usuario usuario;

    public UsuarioXProjeto() {
    }

    public UsuarioXProjeto(UsuarioXProjetoPK usuarioXProjetoPK) {
        this.usuarioXProjetoPK = usuarioXProjetoPK;
    }

    public UsuarioXProjeto(UsuarioXProjetoPK usuarioXProjetoPK, int papel) {
        this.usuarioXProjetoPK = usuarioXProjetoPK;
        this.papel = papel;
    }

    public UsuarioXProjeto(int usuarioId, int projetoId) {
        this.usuarioXProjetoPK = new UsuarioXProjetoPK(usuarioId, projetoId);
    }

    public UsuarioXProjetoPK getUsuarioXProjetoPK() {
        return usuarioXProjetoPK;
    }

    public void setUsuarioXProjetoPK(UsuarioXProjetoPK usuarioXProjetoPK) {
        this.usuarioXProjetoPK = usuarioXProjetoPK;
    }

    public int getPapel() {
        return papel;
    }

    public void setPapel(int papel) {
        this.papel = papel;
    }

    public Projeto getProjeto() {
        return projeto;
    }

    public void setProjeto(Projeto projeto) {
        this.projeto = projeto;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (usuarioXProjetoPK != null ? usuarioXProjetoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsuarioXProjeto)) {
            return false;
        }
        UsuarioXProjeto other = (UsuarioXProjeto) object;
        if ((this.usuarioXProjetoPK == null && other.usuarioXProjetoPK != null) || (this.usuarioXProjetoPK != null && !this.usuarioXProjetoPK.equals(other.usuarioXProjetoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "reqlist.entity.UsuarioXProjeto[ usuarioXProjetoPK=" + usuarioXProjetoPK + " ]";
    }
    
}
