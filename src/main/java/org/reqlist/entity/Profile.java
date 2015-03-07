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
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import org.reqlist.enumerated.RoleEnum;

/**
 * 
 * @author Vinicius Pires <vinicius.costa.pires at gmail.com>
 */
@Entity
@Table(name = "profile")
public class Profile implements Serializable {
    private static final long serialVersionUID = 1L;
    
    @EmbeddedId
    protected ProfileKey profileKey;
    
    @Basic(optional = false)
    @NotNull
    @Column(name = "role")
    private RoleEnum role;
    
    @JoinColumn(name = "usuario_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private User usuario;
    
    @JoinColumn(name = "projeto_id", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private Project projeto;

    public Profile() {
    }

    public Profile(ProfileKey perfilPK) {
        this.profileKey = perfilPK;
    }

    public Profile(ProfileKey profileKey, RoleEnum role) {
        this.profileKey = profileKey;
        this.role = role;
    }

    public Profile(Long userId, Long projectId) {
        this.profileKey = new ProfileKey(userId, projectId);
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (profileKey != null ? profileKey.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Profile)) {
            return false;
        }
        Profile other = (Profile) object;
        if ((this.profileKey == null && other.profileKey != null) || (this.profileKey != null && !this.profileKey.equals(other.profileKey))) {
            return false;
        }
        return true;
    }

    public ProfileKey getProfileKey() {
        return profileKey;
    }

    public void setProfileKey(ProfileKey profileKey) {
        this.profileKey = profileKey;
    }

    public RoleEnum getRole() {
        return role;
    }

    public void setRole(RoleEnum role) {
        this.role = role;
    }

    public User getUsuario() {
        return usuario;
    }

    public void setUsuario(User usuario) {
        this.usuario = usuario;
    }

    public Project getProjeto() {
        return projeto;
    }

    public void setProjeto(Project projeto) {
        this.projeto = projeto;
    }
    
}
