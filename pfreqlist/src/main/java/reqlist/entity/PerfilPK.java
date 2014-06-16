/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package reqlist.entity;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;

/**
 *
 * @author Vinicius
 */
@Embeddable
public class PerfilPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "usuario_id")
    private int usuarioId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "projeto_id")
    private int projetoId;

    public PerfilPK() {
    }

    public PerfilPK(int usuarioId, int projetoId) {
        this.usuarioId = usuarioId;
        this.projetoId = projetoId;
    }

    public int getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(int usuarioId) {
        this.usuarioId = usuarioId;
    }

    public int getProjetoId() {
        return projetoId;
    }

    public void setProjetoId(int projetoId) {
        this.projetoId = projetoId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) usuarioId;
        hash += (int) projetoId;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PerfilPK)) {
            return false;
        }
        PerfilPK other = (PerfilPK) object;
        if (this.usuarioId != other.usuarioId) {
            return false;
        }
        if (this.projetoId != other.projetoId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "reqlist.entity.PerfilPK[ usuarioId=" + usuarioId + ", projetoId=" + projetoId + " ]";
    }
    
}
